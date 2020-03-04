package services;

import data.BookNotFoundException;

public interface PurchasingService
{
	public void buyBook(String isbn) throws BookNotFoundException;
}