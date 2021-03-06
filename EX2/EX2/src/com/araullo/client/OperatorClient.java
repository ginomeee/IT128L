package com.araullo.client;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.araullo.employee.fx.Employee;
import com.araullo.employee.fx.EmployeeFx;
public class OperatorClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8001/employee?wsdl");
		QName qname= new QName("http://impl.employee.araullo.com/", "EmployeeImplService");
	    Service service = Service.create(url, qname);
	    
	    EmployeeFx employee= service.getPort(EmployeeFx.class);
	    
	    Scanner scan = new Scanner(System.in);
		String choice = null;
			
			do {
				menuChoices();
				choice = scan.nextLine();
				switch(choice) 
				{
				
				case "a": 
					Employee emp = new Employee();
					System.out.println("Enter Employee ID: ");
					emp.setId(scan.nextLine());
					System.out.println("Enter Employee Name: ");
					emp.setName(scan.nextLine());
					System.out.println("Enter Employee Number: ");
					emp.setEmployeeNumber(scan.nextLine());
					employee.createEmployee(emp);
					break;
				
				case "b": 
					Employee deleteEmp = new Employee();
					System.out.println("Enter Employee ID for deletion: ");
					deleteEmp.setId(scan.nextLine());
					employee.deleteEmployee(deleteEmp);
					break;
				
				case "c":
					Employee updateEmp = new Employee();
					System.out.println("Enter Employee ID for update: ");
					updateEmp.setId(scan.nextLine());
					System.out.println("Enter updated Employee Name: ");
					updateEmp.setName(scan.nextLine());
					System.out.println("Enter Employee Number for verification: ");
					updateEmp.setEmployeeNumber(scan.nextLine());
					employee.updateEmployee(updateEmp);
					break;
				
				case "d": 
					Employee detailEmp = new Employee();
					System.out.println("Enter Employee ID for details: ");
					detailEmp = employee.getEmployeeDetails(scan.nextLine());
					String pauseInput= "a";
					while(!pauseInput.equals("b"))
					{
						System.out.print("Employee ID: " + detailEmp.getId() + "\n"
										+ "Employee Name: " + detailEmp.getName() + "\n"
										+ "Employee Number: " + detailEmp.getEmployeeNumber() + "\n"
										+ "[b] Back to menu\n");
						pauseInput = scan.nextLine();
						scan.nextLine();
						System.out.print("\n");
					}
					break;
				
				case "e":
					Employee empArray [] = employee.getAllEmployees();
					String pauseInputAll = "a";
					while (!pauseInputAll.equals("b"))
					{
						for(int i=0; i<empArray.length;i++)
						{
							System.out.println("Employee Name: " + empArray[i].getName());
						}
						System.out.println("[b] Back to menu");
						pauseInputAll = scan.nextLine();
						System.out.print("\n");
					}
					break;
				
				case "f":
					break;
					
				default:
					System.out.println("ERROR! Only the choices [a-f] are accepted!\n\n");
					break;
				} 
				
				
			}while (!choice.equals("f"));
		
			scan.close();    
	}
	
	public static void menuChoices()
	{
		System.out.println("EMPLOYEE APPLICATION APP BY ARAULLO: \n\n");
		System.out.println("Please select from the choices below: ");
		System.out.print("-----------------------\n"
				+ "a) Create employee\n"
				+ "b) Delete employee\n"
				+ "c) Update employee\n"
				+ "d) Get details of an employee\n"
				+ "e) Get details of all employees\n"
				+ "f) Quit\n"
				+ "-----------------------\n");
	}

}