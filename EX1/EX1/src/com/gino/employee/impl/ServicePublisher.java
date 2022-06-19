package com.gino.employee.impl;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8001/employee", new EmployeeImpl());
	}
}