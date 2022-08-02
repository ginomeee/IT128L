package com.gabriel.pss.psswsimpl;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
import com.gabriel.pss.psswsservice.PSSWSService;
import com.gabriel.pss.pssfx.Message;
import com.gabriel.pss.pssfx.Messenger;
import com.gabriel.pss.pssfx.Subscriber;

public class MessengerImpl extends TimerTask implements Messenger{
	Subscriber subscriber;
	final int waitsec = 1;
	PSSWSService pssService;
	Timer timer = new Timer(true);
	public MessengerImpl() throws Exception
	{	
		init();
	}
		
	void init()throws Exception
	{
		URL url = new URL("http://localhost:8779/ws/PSS?wsdl");  
        QName qname = new QName("http://psswsservice.pss.gabriel.com/", "PSSWSServiceImplService");  
        Service service = Service.create(url, qname);  
        pssService  = service.getPort(PSSWSService.class);
	}	
	
	@Override
	public void publish(Message message) throws Exception{
		String ret = pssService.publish(message.getTopic(),message.getPayload());
	}

	@Override
	public void subscribe(Subscriber subscriber, String topic)  throws Exception{
		this.subscriber = subscriber;
		String ret = pssService.subscribe(topic, subscriber.getSubscriberName());        
		timer.scheduleAtFixedRate(this, 0, waitsec* 1000);
	}

	@Override
	public void run() {
		com.gabriel.pss.psswsservice.Message[] messeages = pssService.getAllMessages(subscriber.getSubscriberName());
		for(int i=0; i<messeages.length; i++) 
		{	
			com.gabriel.pss.pssfx.Message message =new com.gabriel.pss.pssfx.Message ();
			message.setTopic(messeages[i].getTopic());
			message.setPayload(messeages[i].getPayload());				
			subscriber.receive(message);			
		}
		String[] subscribers = pssService.getAllSubscribers();
		subscriber.receive(subscribers);
	}	
}
