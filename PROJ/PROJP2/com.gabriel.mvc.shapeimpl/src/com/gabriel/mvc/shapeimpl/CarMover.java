package com.gabriel.mvc.shapeimpl;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;
import com.gabriel.mvc.shapesfx.Mover;

public class CarMover extends Mover{
	public void move(MyShape shape, Location changeLocation)
	{
		Car car = (Car)shape;
		super.move(car, changeLocation);
		Mover mover = new Mover();
		
		CarBody body = car.getBody();
		mover.move(body, changeLocation);
		
		Wheel front = car.getFrontWheel();
		mover.move(front, changeLocation);
		Wheel back = car.getBackWheel();
		mover.move(back, changeLocation);	
		
		Wheel lampos = car.getLamp();
		mover.move(lampos, changeLocation);	
		
		Polytop polyTop = car.getPolytop(); 
		mover.move(polyTop, changeLocation);
		
		
	}
}
