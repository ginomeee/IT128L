package com.gabriel.mvc.shapeimpl;

import java.awt.Graphics;
import java.awt.Color;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Renderer;

public class WheelRenderer implements Renderer {

	public void draw(Object context, MyShape shape) {
		Graphics g = (Graphics) context;
		Wheel wheel = (Wheel) shape;
		g.setColor(Color.black);
		int diff = (wheel.getOutRadius() - wheel.getRadius())/2;
		g.fillOval(wheel.getLocation().getX(), wheel.getLocation().getY(), wheel.getOutRadius(), wheel.getOutRadius());
		g.setColor(Color.yellow);
		g.fillOval(wheel.getLocation().getX()+diff, wheel.getLocation().getY()+diff, wheel.getRadius(), wheel.getRadius());
		
	}
}
