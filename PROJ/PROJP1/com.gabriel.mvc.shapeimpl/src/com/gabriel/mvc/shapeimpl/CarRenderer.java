package com.gabriel.mvc.shapeimpl;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Renderer;

public class CarRenderer implements Renderer {

	@Override
	public void draw(Object context, MyShape shape) {
		Car car = (Car)shape;
		
		CarBody carBody = car.getBody();
		CarBodyRenderer carBodyRenderer = new CarBodyRenderer();
		carBodyRenderer.draw(context, carBody);
		
		WheelRenderer wheelRenderer = new WheelRenderer();
		Wheel frontWheel = car.getFrontWheel();
		wheelRenderer.draw(context, frontWheel);
		Wheel backWheel = car.getBackWheel();
		wheelRenderer.draw(context, backWheel);
		
		Wheel lamped = car.getLamp();
		wheelRenderer.draw(context, lamped);
		
		
		Polytop polyTop = car.getPolytop();
		PolytopRenderer polytopRenderer = new PolytopRenderer();
		polytopRenderer.draw(context, polyTop);
		
		
	}

}
