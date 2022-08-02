package com.gabriel.mvc.shapeimpl;
import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;

public class Car implements MyShape{
	
	CarBody body;
	Wheel frontWheel;
	Wheel backWheel;
	Wheel Lampo;
	Polytop thetop;
	Location location;
	
	

	public CarBody getBody() {
		return body;
	}

	public void setBody(CarBody body) {
		this.body = body;
	}
	
	public Polytop getPolytop() {
		return thetop;
	}	
	
	public void setPolytop(Polytop thetop) {
		this.thetop = thetop;
	}
/* Not needed
	
		

	public Polytop getXCoords() {
		return polyTop;
	}
	public void setXCoords(Polytop polytop) {
		this.polyTop = polytop;
	}
	public Polytop getYCoords(Polytop polytop) {
		return polytop;
	}
	public void setYCoords(Polytop polytop) {
		this.polyTop = polytop;
	}
	 
*/
	public Wheel getFrontWheel() {
		return frontWheel;
	}

	public void setFrontWheel(Wheel frontWheel) {
		this.frontWheel = frontWheel;
	}

	public Wheel getBackWheel() {
		return backWheel;
	}

	public void setBackWheel(Wheel backWheel) {
		this.backWheel = backWheel;
	}
	
	public Wheel getLamp() {
		return Lampo;
	}

	public void setLamp(Wheel Lampo) {
		this.Lampo = Lampo;
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
