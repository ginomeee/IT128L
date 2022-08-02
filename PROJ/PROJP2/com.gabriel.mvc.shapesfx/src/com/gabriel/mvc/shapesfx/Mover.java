package com.gabriel.mvc.shapesfx;

public class Mover {
	public void move(MyShape shape, Location changeLocation)
	{
		int x = shape.getLocation().getX();
		int y = shape.getLocation().getY();
		
		int dx = changeLocation.getX();
		int dy = changeLocation.getY();
		
		shape.getLocation().setX(x+dx);
		shape.getLocation().setY(y+dy);
	}
}
