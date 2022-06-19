package com.araullo.employee.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.araullo.employee.fx.Employee;
import com.araullo.employee.fx.EmployeeFx;

@WebService (endpointInterface="com.araullo.employee.fx.EmployeeFx")
public class EmployeeImpl implements EmployeeFx{
	Map <String,Employee> employees = new HashMap<String,Employee>();
	@Override
	public Employee getEmployeeDetails(String id) {
		if(employees.containsKey(id))
			return employees.get(id);
		return new Employee();
	}
	@Override
	public String createEmployee(Employee employee) {
                try{
		        employees.put(employee.getId(), employee);
                        return "success";
                }catch(Exception e){
			return "failed";
		}		
	}

	@Override
	public Employee [] getAllEmployees() {
		ArrayList<Employee> emps = new  ArrayList<Employee>();
		Employee emp=null;
		
		for(Map.Entry<String, Employee> e : employees.entrySet())
		{
			emp=new Employee();
			emp.setId(e.getKey());
			emp.setName(e.getValue().getName());
			emps.add(emp);
		}
		return  (Employee []) emps.toArray(new Employee[emps.size()]);
	}
	@Override
	public String removeEmployee(Employee employee) {
		try {
			employees.remove(employee.getId());
			return "removed";	
		}
		catch (Exception e) {
			return "failed";
		}
	}
	@Override
	public String updateEmployee(Employee employee) {
		try {
			employees.replace(employee.getId(), employee);
			return "removed";	
		}
		catch (Exception e) {
			return "failed";
		}
	}
}