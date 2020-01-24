package client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Book;
import services.BookService;

public class Client
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

        BookService service = container.getBean(BookService.class);

        List<Book> allBooks = service.getEntireCatalogue();
        for (Book next : allBooks)
        {
            System.out.println(next);
        }
    }
}