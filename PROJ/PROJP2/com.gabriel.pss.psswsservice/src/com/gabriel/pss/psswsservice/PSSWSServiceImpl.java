package com.gabriel.pss.psswsservice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;  

@WebService(endpointInterface = "com.gabriel.pss.psswsservice.PSSWSService")  
public class PSSWSServiceImpl implements PSSWSService{
	static HashMap<String, HashMap<String,ArrayList<Object>>> map = new HashMap<>();
	
    @Override  
	@WebMethod  public String publish(String topic, Object payload)
	{    	
    	String ret = "OK";
    	synchronized(map) {
	    	if(!map.containsKey(topic))
	    	{
	    		map.put(topic, new HashMap<String, ArrayList<Object>>());    		
	    	}
	    	for (Iterator<String> i = (map.get(topic)).keySet().iterator(); i.hasNext();)
	    	{
	    		String recipientName = i.next();
				ArrayList<Object> payLoads = map.get(topic).get(recipientName); 
				payLoads.add(payload);
	    	}
    	 }
    	return ret;
	}

    @Override  
	@WebMethod  public String subscribe(String topic, String recipientName)
	{
    	String ret = "OK";
    	synchronized(map) 
    	{
	    	if(!map.containsKey(topic))
	    	{
	    		map.put(topic, new HashMap<String, ArrayList<Object>>());    		
	    	}
	    	if(!map.get(topic).containsKey(recipientName))
	    	{
	    		map.get(topic).put(recipientName, new ArrayList<Object>());    		
	    	}
	    	else
	    	{    		
	    		ret = "Topic recipient exists";
	    	}
    	}
    	return ret;    	
	}
    
    @Override  
	@WebMethod  public Message[] getAllMessages(String recipientName)
	{
    	ArrayList<Message> rets = new  ArrayList<Message>();
    	synchronized(map)
    	{    	
	    	for (Iterator<String> i = map.keySet().iterator(); i.hasNext();)
	    	{
	    		String topicName = i.next();
	    		if(map.get(topicName).containsKey(recipientName))
	    		{    	
	    			ArrayList<Object> payLoads = map.get(topicName).get(recipientName); 
	    			for (Iterator<Object> j = payLoads.iterator(); j.hasNext();)
	    			{
	    				Object payload =j.next();
	    				Message message = new Message();
	    				message.setPayload(payload);
	    				message.setTopic(topicName);
	    				rets.add(message);
	    			}    			
	    			map.get(topicName).get(recipientName).removeAll(payLoads);
	    		}
	    	}
    	}    	
    	return (Message[]) rets.toArray(new Message[rets.size()]);
	}

	@Override
	public String[] getAllSubscribers() {
		List<String> names = new ArrayList<String>();
    	for (Iterator<String> i = map.keySet().iterator(); i.hasNext();)
    	{
    		String topicName = i.next();
			HashMap<String, ArrayList<Object>> recipients = map.get(topicName); 
			for (Iterator<String> j = recipients.keySet().iterator(); j.hasNext();)
			{
				String recipientName = j.next();
				if(!names.contains(recipientName)){
					names.add(recipientName);
				}
			}
    	}    		    		
		return (String[]) names.toArray(new String[names.size()]);
	}
}
