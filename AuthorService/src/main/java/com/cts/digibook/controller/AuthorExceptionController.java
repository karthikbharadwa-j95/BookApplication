package com.cts.digibook.controller;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.digibook.exception.AuthorException;
import com.cts.digibook.response.Response;

@ControllerAdvice
public class AuthorExceptionController {

	@ExceptionHandler(AuthorException.class)
	public final ResponseEntity<Response> exception(AuthorException bookAppException) {
		Response response = new Response();
		response.setIsError(true);
		response.setMsg(bookAppException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}