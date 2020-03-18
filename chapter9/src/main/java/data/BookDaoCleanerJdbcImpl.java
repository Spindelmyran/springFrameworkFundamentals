package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class BookDaoCleanerJdbcImpl implements BookDao {

	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_BOOK_SQL = "insert into BOOK (ISBN, TITLE, AUTHOR,PRICE) values (?, ?, ?, ?) ";
	private static final String CREATE_TABLE_SQL = "create table BOOK(ISBN VARCHAR(20), TITLE VARCHAR(50), AUTHOR VARCHAR(50), PRICE DOUBLE)";
	private static final String GET_ALL_BOOKS_SQL = "select * from BOOK";
	
	public BookDaoCleanerJdbcImpl(JdbcTemplate template)
	{
		this.jdbcTemplate = template;
		
		// TODO: improve this try block
		try
		{
			jdbcTemplate.update(CREATE_TABLE_SQL);
		}
		catch (Exception e)
		{
			System.out.println("Assuming that the table already exists");
		}
	}
	
	public List<Book> allBooks() {
		return jdbcTemplate.query(GET_ALL_BOOKS_SQL, (RowMapper) new BookMapper());
	}

	public Book findByIsbn(String isbn) {
		return (Book) jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE ISBN=?", new Object[] {isbn}, new BookMapper());
	}

	public void create(Book newBook) {
		jdbcTemplate.update(INSERT_BOOK_SQL, new Object[] {newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPrice()});
	}

	public void delete(Book redundantBook) {
		jdbcTemplate.update("DELETE FROM BOOK WHERE ISBN=?",new Object[] { redundantBook.getIsbn()});
	}

	public List<Book> findBooksByAuthor(String author) {
		return jdbcTemplate.query("SELECT * FROM BOOK WHERE AUTHOR=?", new Object[] {author}, (RowMapper) new BookMapper());
	}


}
class BookMapper implements ResultSetExtractor, RowCallbackHandler, RowMapper {
	public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		return null;
	}

	public void processRow(ResultSet resultSet) throws SQLException {

	}

	public Object mapRow(ResultSet resultSet, int i) throws SQLException {
		return null;
	}
}

/*class BookMapper implements RowMapper<Book>
{
	public Book mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		String isbn = rs.getString("ISBN");
		String title = rs.getString("TITLE");
		String author =rs.getString("AUTHOR");
		double price = rs.getDouble("PRICE");

		Book theBook = new Book(isbn, title, author, price);
		return theBook;
	}

}*/
