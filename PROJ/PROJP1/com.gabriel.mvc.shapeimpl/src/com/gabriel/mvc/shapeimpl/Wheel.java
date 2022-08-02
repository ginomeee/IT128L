package com.gabriel.mvc.shapeimpl;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;

public class Wheel implements MyShape{

	Location location;
	int radius;
	int outRadius = radius;
	
	public int getOutRadius() {
		return outRadius;
	}
	
	public void setOutRadius(int outRadius) {
		this.outRadius = outRadius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	} 

	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;		
	}
}
