package com.cts.digibook.controller;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.digibook.exception.ReaderException;
import com.cts.digibook.response.*;

@ControllerAdvice
public class ReaderExceptionController {

	@ExceptionHandler()
	public final ResponseEntity<Response> exception(ReaderException readerException) {
		Response response = new Response();
		response.setIsError(true);
		response.setMsg(readerException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
