package services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import data.BookDao;
import data.BookNotFoundException;
import domain.Book;

/**
 * This is the production implementation - it will be calling a "real" database.
 */
@Transactional
@Service("bookService")
public class BookServiceProductionImpl implements BookService {
	
	@Autowired
	private BookDao dao;

	public List<Book> getAllBooksByAuthor(String author) {
		return dao.findBooksByAuthor(author);
	}

	public List<Book> getAllRecommendedBooks(String userId) {
		throw new UnsupportedOperationException();
	}

	@Transactional(readOnly=true)
	public Book getBookByIsbn(String isbn) throws BookNotFoundException {
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

	public void deleteFromStock(Book oldBook)
	{
		dao.delete(oldBook);
	}

}
