package com.cts.digibook.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digibook.dto.ChangeAuthorPassword;
import com.cts.digibook.dto.UpdateBook;
import com.cts.digibook.entity.Author;
import com.cts.digibook.entity.BookShelf;
import com.cts.digibook.response.Response;
import com.cts.digibook.service.AuthorService;





@RestController
@RequestMapping("/api/v1/digitalbooks/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/home")
	public String home() {
		return "<h1> Welocome to Author Page<h1>";
	}

	// adding a Author
	@PostMapping("/signup")
	public ResponseEntity<Response> addAuthor(@RequestBody Author author) {
		// log.info("ERROR<==");
		Response response = new Response();
		Author addAuthor = authorService.addAuthor(author);

		if (addAuthor != null) {
			response.setIsError(false);
			response.setMsg("Data added successful");
			response.setData(addAuthor);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Data was not added successfully!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	//author adding book
	@SuppressWarnings("unused")
	@PostMapping("/books")
	public ResponseEntity<Response> createBook(@RequestBody BookShelf bookShelf) {
		Response response = new Response();
		BookShelf addBook = authorService.createBook(bookShelf);
		if (addBook != null) {
			response.setIsError(false);
			response.setMsg("Book added successful");
			response.setData(addBook);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Book was not added successfully!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/changePassword")
	public ResponseEntity<Response> authorChangePassword(@RequestBody ChangeAuthorPassword changeAuthorPassword) {
		ChangeAuthorPassword changedPassword = authorService.changePassword(changeAuthorPassword);
		Response response = new Response();
		if (changedPassword != null) {
			response.setIsError(false);
			response.setMsg("Password was changed successfully for empId:" + changedPassword.getAuthorId());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Please enter the correct credentials!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/{authorId}/books/{bookId}")
	public ResponseEntity<Response> updateAuthorBook(@PathVariable("authorId") String authorId,
			@PathVariable("bookId") String bookId, @RequestBody UpdateBook updateBook) {
		BookShelf updateBookShelf = authorService.updateBook(authorId, bookId, updateBook);
		Response response = new Response();
		if (updateBookShelf != null) {
			response.setIsError(false);
			response.setMsg("Book updated successfully");
			response.setData(updateBookShelf);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setIsError(true);
			response.setMsg("Book was not updated successfully!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}

