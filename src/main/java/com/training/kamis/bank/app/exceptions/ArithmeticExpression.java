package com.training.kamis.bank.app.exceptions;

public class ArithmeticExpression extends RuntimeException {
	public ArithmeticExpression() {
		
	}
	
	public ArithmeticExpression(String message) {
		super(message);
	
	}
}
