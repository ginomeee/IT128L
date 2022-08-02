package com.gabriel.mvc.shapeimpl;

import java.awt.Graphics;
import java.awt.Color;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Renderer;

public class CarBodyRenderer implements Renderer {

	@Override
	public void draw(Object context, MyShape shape) {
		Graphics g = (Graphics) context;
		CarBody carBody = (CarBody) shape;
		int aborder = carBody.getBorder();
		int halfborder = (aborder/2);
		g.setColor(Color.black);
		g.fillRect(carBody.getLocation().getX()-halfborder,carBody.getLocation().getY()-halfborder,carBody.getWidth()+aborder, carBody.getLength()+aborder);
		g.setColor(Color.red);
		g.fillRect(carBody.getLocation().getX(),carBody.getLocation().getY(),carBody.getWidth(), carBody.getLength());
	}

}
