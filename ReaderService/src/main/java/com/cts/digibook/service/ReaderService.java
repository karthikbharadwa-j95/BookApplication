package com.cts.digibook.service;

import com.cts.digibook.dto.BooksDto;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.entity.Reader;
import com.cts.digibook.entity.Subscription;

public interface ReaderService {

	public Reader addReader(Reader readerInfo);

	public Subscription bookSubscription(Subscription subscription);

	public BooksDto fetchBooks(String readerId);

	public BookShelf readBook(String readerEmail, String bookId);

	public BookShelf fetchBySubId(String subId);
}
