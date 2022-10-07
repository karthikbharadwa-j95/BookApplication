package com.cts.digibook.exception;

public class ReaderException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		return this.message;
	}

	public ReaderException(String message) {
		this.message = message;
	}

}
