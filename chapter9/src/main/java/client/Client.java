package client;

import domain.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.BookService;
import services.PurchasingService;

import java.util.List;

public class Client 
{
	public static void main(String[] args)
	{

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

		BookService bookService = container.getBean(BookService.class);

		bookService.registerNewBook(new Book("1234567","Krig och fred","Leo Tolstoy",100));

		List<Book> allBooks = bookService.getEntireCatalogue();
		for (Book next: allBooks)
		{
			System.out.println(next);
		}
		
		container.close();
	}
}
