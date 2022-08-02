package com.gabriel.mvc.subscribingview;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.gabriel.mvc.shapeimpl.CarMover;
import com.gabriel.mvc.shapeimpl.CarRenderer;
import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;
import com.gabriel.mvc.shapesfx.Mover;
import com.gabriel.mvc.shapesfx.Renderer;
import com.gabriel.pss.pssfx.Message;
import com.gabriel.pss.pssfx.Messenger;
import com.gabriel.pss.pssfx.Subscriber;
import com.gabriel.pss.psswsimpl.MessengerImpl;

public class SubscriberView  extends JFrame implements Subscriber{
	Messenger messenger;
	String subscriberName;
	MyShape car;
	Mover mover;
	int speed = 10;
	Renderer renderer = new CarRenderer();
	void init(MyShape car) {
		this.subscriberName = "carview";
		this.car = car;
		mover = new CarMover();
		try {
			messenger = new MessengerImpl();
			messenger.subscribe(this, getSubscriberName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void initUI() {		
		setLayout(null);
		setVisible(true);
		setSize(500,500);
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0,0,600,600);
		renderer.draw(g, car);
	}
	@Override
	public String getSubscriberName() {
		return subscriberName;
	}
	@Override
	public void receive(Message message) {
		String str = (String)message.getPayload();
				
		Location changedLocation = new Location();			
		if(str.equals("Right"))
		{
			 changedLocation.setX(speed);
			 changedLocation.setY(0);
			 mover.move(car, changedLocation);			 
			 repaint();
		}
		else if(str.equals("Left"))
		{
			 changedLocation.setX(-speed);
			 changedLocation.setY(0);
			 mover.move(car, changedLocation);			
			 repaint();
		}
		else if(str.equals("Up"))
		{
			 changedLocation.setX(0);
			 changedLocation.setY(-speed);
			 mover.move(car, changedLocation);			
			 repaint();
		}
		else if(str.equals("Down"))
		{
			 changedLocation.setX(0);
			 changedLocation.setY(speed);
			 mover.move(car, changedLocation);
			 repaint();
		}
		else if(str.equals("Faster"))
		{
			 speed = speed + 10;			 
		}							
		else if(str.equals("Slower"))
		{
			 speed = speed - 10;			 
		}							
	}
	@Override
	public void receive(String[] topics) {
		// TODO Auto-generated method stub
		
	}
}
