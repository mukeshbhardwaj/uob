package com.uob.uobbank;

public class InsufficientBalanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
		super();
	}

	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}

	public InsufficientBalanceException(Throwable cause) {
		super(cause);
	}
}
