package client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Customer;
import services.customers.CustomerManagementService;

public class SimpleClientTest {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		
		CustomerManagementService customerService = container.getBean(CustomerManagementService.class);
		
		List<Customer> allCustomers = customerService.getAllCustomers();
		
		for (Customer next: allCustomers)
		{
			System.out.println(next);
		}
		
		container.close();
	}

}
