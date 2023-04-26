package com.test.exception;

/**
 * Common Exception to handle invalid user inputs
 */
public class InValidParameterException extends RuntimeException {

    public InValidParameterException(String message) {
		super(message);
	}

	public InValidParameterException(String message, Throwable throwable) {
		super(message, throwable);
	}    
}

