package client;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;
import com.gino.operator.fx.OperatorService;


public class OperatorClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:10008/compute?wsdl");
		QName qname = new QName("http://impl.operator.gino.com/","OperatorServiceImplService");
		Service service = Service.create(url,qname);
		
		System.out.println("Simple Calculator by ARAULLO, Eugenio Emmanuel A.");
		System.out.println("There are two numbers: 2 and 5");
		OperatorService operator=service.getPort(OperatorService.class);
		System.out.println("The Sum is: " + operator.getSum(2,5));
		System.out.println("The Difference is: " + operator.getDifference(2,5));
		System.out.println("The Product is: " + operator.getProduct(2,5));
		System.out.println("The Quotient is: " + operator.getQuotient(2,5));
	}
}
