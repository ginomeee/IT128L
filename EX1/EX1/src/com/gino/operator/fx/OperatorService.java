package com.gino.operator.fx;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)
public interface OperatorService {
	@WebMethod double getSum(double x, double y);
	@WebMethod double getProduct(double x, double y);
	@WebMethod double getDifference(double x, double y);
	@WebMethod double getQuotient(double x, double y);
}
