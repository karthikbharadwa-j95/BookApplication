package com.cts.digibook.exception;

public class AuthorException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

	public AuthorException(String message) {
		this.message = message;
	}

}