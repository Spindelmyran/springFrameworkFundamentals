package services;

import domain.Book;

public class PurchasingServiceImpl implements PurchasingService
{
	private AccountsService accounts;
	private BookService books;

	public PurchasingServiceImpl(AccountsService accountsService, BookService booksService)
	{
		this.accounts = accountsService;
		this.books = booksService;
	}

/*	public void setAccountsService(AccountsService accounts) {
		this.accounts = accounts;
	}

	public void setBookService(BookService books) {
		this.books = books;
	}*/
	public void buyBook(String isbn)
	{
		// find the correct book
		Book requiredBook = books.getBookByIsbn(isbn);

		// now raise the invoice
		accounts.raiseInvoice(requiredBook); 
	}

}
