package com.cts.digibook.service;

import com.cts.digibook.dto.ChangeAuthorPassword;
import com.cts.digibook.dto.UpdateBook;
import com.cts.digibook.entity.Author;
import com.cts.digibook.entity.BookShelf;

public interface AuthorService {

	public Author addAuthor(Author authorinfo);
	
	public ChangeAuthorPassword changePassword(ChangeAuthorPassword password);
	
	public BookShelf createBook(BookShelf shelf);
	
	public BookShelf updateBook(String bookId, String authorId, UpdateBook updateBook);
}
