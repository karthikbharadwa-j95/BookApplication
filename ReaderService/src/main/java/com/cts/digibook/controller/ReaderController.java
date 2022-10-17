package com.cts.digibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digibook.dto.BooksDto;
import com.cts.digibook.dto.ReaderLogin;
import com.cts.digibook.dto.SearchBooks;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.entity.Reader;
import com.cts.digibook.entity.Subscription;
import com.cts.digibook.entity.User;
import com.cts.digibook.response.Response;
import com.cts.digibook.service.ReaderService;

@RestController
@RequestMapping("/api/v1/digitalbooks/readers")
public class ReaderController {

	@Autowired
	private ReaderService readerService;

	@GetMapping("/home")
	public String home() {
		return "<h1> Welocome to Reader Page<h1>";
	}

	// reader signup
	@PostMapping("/signup")
	public ResponseEntity<Response> addReader(@RequestBody Reader reader) {
		// log.info("ERROR<==");
		Response response = new Response();
		Reader addReader = readerService.addReader(reader);

		if (addReader != null) {
			response.setIsError(false);
			response.setMsg("Data added successful");
			response.setData(addReader);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Data was not added successfully!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	// reader login
	@PostMapping("/login")
	public ResponseEntity<Response> readerLogin(@RequestBody ReaderLogin readerLogin) {
		Response response = new Response();
		User login = readerService.readerLogin(readerLogin);
		if (login != null) {
			response.setIsError(false);
			response.setMsg("Login successful!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Unable to login!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// reader subscribing the book
	@PostMapping("/subscribe")
	public ResponseEntity<Response> bookSubscription(@RequestBody Subscription subscription) {
		Response response = new Response();
		Subscription bookSubscription = readerService.bookSubscription(subscription);
		if (bookSubscription != null) {
			response.setIsError(false);
			response.setMsg("Data added successful");
			response.setData(bookSubscription);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Data was not added successfully!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// reader searching book
	@PostMapping("/books")
	public List<BookShelf> searchBook(@RequestBody SearchBooks searchBooks) {
		Response response = new Response();
		List<BookShelf> books = readerService.searchBooks(searchBooks);
//		if (books != null) {
//			response.setIsError(false);
//			response.setMsg("Book Found!");
//			response.setData(books);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} else {
//			response.setIsError(true);
//			response.setMsg("Error finding the book!");
//			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//		}
		return books;

	}

	// reader finding all purchased books
	@GetMapping("/{readerId}/books")
	public ResponseEntity<Response> fetchBooks(@PathVariable String readerId) {
		Response response = new Response();
		BooksDto fetchBooks = readerService.fetchBooks(readerId);
		if (fetchBooks != null) {
			response.setIsError(false);
			response.setMsg("Following are the books under the entered reader id");
			response.setData(fetchBooks);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("No books found under this Id!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// reader reading a book
	@GetMapping("/{readerEmail}/books/{bookId}")
	public ResponseEntity<Response> readBook(@PathVariable("readerEmail") String readerEmail,
			@PathVariable("bookId") String bookId) {
		Response response = new Response();
		BookShelf readBook = readerService.readBook(readerEmail, bookId);
		if (readBook != null) {
			response.setIsError(false);
			response.setMsg("Happy reading!");
			response.setData(readBook);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Invalid credentials!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	// reader fetching book by subscription Id
	@GetMapping("/books/{subId}")
	public ResponseEntity<Response> fetchBySubId(@PathVariable String subId) {
		Response response = new Response();
		BookShelf fetchBySubId = readerService.fetchBySubId(subId);
		if (fetchBySubId != null) {
			response.setIsError(false);
			response.setMsg("Book against your payment is:" + fetchBySubId.getTitle());
			response.setData(fetchBySubId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Please subscribe!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
