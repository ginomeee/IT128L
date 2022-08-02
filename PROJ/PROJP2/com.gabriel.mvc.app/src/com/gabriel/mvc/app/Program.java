package com.gabriel.mvc.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.gabriel.mvc.shapeimpl.Car;
import com.gabriel.mvc.shapeimpl.CarBody;
import com.gabriel.mvc.shapeimpl.Wheel;
import com.gabriel.mvc.shapeimpl.Polytop;
import com.gabriel.mvc.shapesfx.Location;


public class Program {
	
	static Car initCar() {
		Car car = new Car();

		Wheel front = new Wheel();
		Location location = new Location();
		location.setX(175);
		location.setY(150);		
		front.setLocation(location);
		front.setRadius(50);;
		car.setFrontWheel(front);
		
		Wheel back = new Wheel();
		location = new Location();
		location.setX(125);
		location.setY(150);		
		back.setLocation(location);
		back.setRadius(50);
		car.setBackWheel(back);
			
		CarBody carBody = new CarBody();
		location = new Location();
		location.setX(100);
		location.setY(100);
		carBody.setLocation(location);
		carBody.setWidth(200);
		carBody.setLength(100);
		car.setBody(carBody);			
		
		Polytop polyTop = new Polytop();
		location = new Location();
		location.setX(100);
		location.setY(100);
		polyTop.setLocation(location);
		//polyTop.setYCoords(0, 0, 0, 0);
		//polyTop.setXCoords(0, 0, 0, 0);
		
		location = new Location();
		location.setX(100);
		location.setY(100);
		car.setLocation(location);
		return car;
	}
	
	public static void main(String[] args) {
//		Car car = initCar();
		
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  	      
	  
      Car car=(Car) factory.getBean("car");	  
		
		CarView carView = new CarView();
		carView.init(car);
		carView.initUI();

		CarController carController  = new CarController ();
		carController.init(car,carView);
		carController.initUI();
		
	}

}
