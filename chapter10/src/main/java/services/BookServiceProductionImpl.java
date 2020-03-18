package services;

import java.util.List;

import data.BookDao;
import domain.Book;

/**
 * This is the production implementation - it will be calling a "real" database.
 */
public class BookServiceProductionImpl implements BookService {
	
	private BookDao dao;
	
	public BookServiceProductionImpl(BookDao dao)
	{
		this.dao = dao;
	}
	
	public List<Book> getAllBooksByAuthor(String author) {
		return dao.findBooksByAuthor(author);
	}

	public List<Book> getAllRecommendedBooks(String userId) {
		throw new UnsupportedOperationException();
	}

	public Book getBookByIsbn(String isbn) {
		return dao.findByIsbn(isbn);
	}

	public List<Book> getEntireCatalogue() {
		return dao.allBooks();
	}

	public void registerNewBook(Book newBook)
	{
		// we want this book to be put into the database.
		dao.create(newBook);
	}

}
