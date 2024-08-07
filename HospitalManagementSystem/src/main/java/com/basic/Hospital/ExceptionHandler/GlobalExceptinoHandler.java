package com.basic.Hospital.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptinoHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleIdNotFoundException(IdNotFoundException ex){
		
		ErrorResponse err = new ErrorResponse(0, null, null) ;
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
}
