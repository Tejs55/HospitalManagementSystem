package com.basic.Hospital.ExceptionHandler;

public class IdNotFoundException extends RuntimeException{
	
	public IdNotFoundException(String message) {
		super (message);
	}

	public IdNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}
