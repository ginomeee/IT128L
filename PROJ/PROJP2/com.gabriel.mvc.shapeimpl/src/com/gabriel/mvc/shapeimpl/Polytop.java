package com.gabriel.mvc.shapeimpl;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;

public class Polytop implements MyShape{

	Location location;
	public int x1[];
	public int y1[];
	public int points;
	
	public void setpoints(int point) {
		this.points = point;
	}
	
	public int getpoints() {
		return points;
	}
	
	public void setx1(int[] d1) {
		this.x1 = d1;
	}
	
	public int[] getx1() {	
		return x1;
	}
	
	public void sety1(int[] e1) {
		this.y1 = e1;
	}
	
	public int[] gety1() {	
		return y1;
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
