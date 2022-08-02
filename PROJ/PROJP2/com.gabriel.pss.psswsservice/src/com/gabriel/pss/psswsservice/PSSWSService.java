package com.gabriel.pss.psswsservice;

import javax.jws.WebMethod;  
import javax.jws.WebService;  
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style;  
//Service Endpoint Interface  
@WebService  
@SOAPBinding(style = Style.RPC)  
public interface PSSWSService {

	@WebMethod  String publish(String topic, Object payload);
	@WebMethod  String subscribe(String topic, String recipientName);
	@WebMethod   Message[] getAllMessages(String recipientName);
	@WebMethod   String[] getAllSubscribers();
}
