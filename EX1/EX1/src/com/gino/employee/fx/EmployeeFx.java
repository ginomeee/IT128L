package com.gino.employee.fx;

import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface EmployeeFx {
	@WebMethod
	Employee getEmployeeDetails(String id);

	@WebMethod
	String createEmployee(Employee employee);

	@WebMethod
	Employee[] getAllEmployees();
}