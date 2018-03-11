package com.sbjpa.springbootjpa.exception;

public class CustomException extends Exception {
	
	private static final long serialVersionUID = -9079454849611061074L;

	public CustomException() {
		super();
	}

	public CustomException(final String message) {
		super(message);
	}

}
