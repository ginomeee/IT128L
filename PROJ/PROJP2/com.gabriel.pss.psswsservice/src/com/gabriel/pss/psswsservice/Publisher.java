package com.gabriel.pss.psswsservice;

import javax.xml.ws.Endpoint;

public class Publisher {
	 public static void main(String[] args) {  
	       Endpoint.publish("http://localhost:8779/ws/PSS", new PSSWSServiceImpl());  
     }  
}
