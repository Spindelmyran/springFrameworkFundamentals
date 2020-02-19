package services;

import domain.Book;

public class AccountsServiceMockImpl2 implements AccountsService
{	
	public void raiseInvoice(Book requiredBook) 
	{
		// a very basic implementation for testing
		System.out.println("Raised the invoice for ------------------------->" + requiredBook);
	}
}
