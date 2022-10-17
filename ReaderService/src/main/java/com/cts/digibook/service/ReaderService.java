package com.cts.digibook.service;

import java.util.List;

import com.cts.digibook.dto.BooksDto;
import com.cts.digibook.dto.ReaderLogin;
import com.cts.digibook.dto.SearchBooks;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.entity.Reader;
import com.cts.digibook.entity.Subscription;
import com.cts.digibook.entity.User;

public interface ReaderService {

	public Reader addReader(Reader readerInfo);
	
	public User readerLogin (ReaderLogin readerLogin);

	public Subscription bookSubscription(Subscription subscription);

	public BooksDto fetchBooks(String readerId);

	public BookShelf readBook(String readerEmail, String bookId);

	public BookShelf fetchBySubId(String subId);
	
	public List<BookShelf> searchBooks(SearchBooks books);
}
