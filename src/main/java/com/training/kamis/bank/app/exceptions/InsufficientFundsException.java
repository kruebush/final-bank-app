package com.training.kamis.bank.app.exceptions;

public class InsufficientFundsException extends RuntimeException {
	public InsufficientFundsException() {
		
	}
	
	public InsufficientFundsException(String message) {
		super(message);
	
	}
}
