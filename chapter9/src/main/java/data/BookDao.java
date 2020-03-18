package data;

import domain.Book;

import java.util.List;

public interface BookDao 
{
	   public List<Book> allBooks();
	   public Book findByIsbn(String isbn);
	   public void create(Book newBook);
	   public void delete(Book redundantBook);
	   public List<Book> findBooksByAuthor(String author);   
}
