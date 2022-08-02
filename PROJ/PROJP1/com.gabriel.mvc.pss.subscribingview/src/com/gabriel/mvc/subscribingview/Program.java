package com.gabriel.mvc.subscribingview;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.gabriel.mvc.shapeimpl.Car;

public class Program {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  	      
	  
        Car car=(Car) factory.getBean("car");	  

		
		SubscriberView subscriberView  = new SubscriberView(); 
		subscriberView.init(car);
		subscriberView.initUI();
	}

}
