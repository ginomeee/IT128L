package com.gino.operator.impl;

import java.net.MalformedURLException;
import javax.xml.ws.Endpoint;

public class SOAPPublisher {
	public static void main(String[] args) throws MalformedURLException {
		Endpoint.publish("http://localhost:10008/compute", new OperatorServiceImpl());
	}

}
