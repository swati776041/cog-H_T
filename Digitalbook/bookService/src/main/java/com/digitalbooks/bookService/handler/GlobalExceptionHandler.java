package com.digitalbooks.bookService.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.digitalbooks.bookService.entity.MyErrorMessage;
import com.digitalbooks.bookService.exception.BookException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookException.class)
	public ResponseEntity<MyErrorMessage> handleBookException(BookException me){
		return new ResponseEntity<>(
				new MyErrorMessage(me.getMessage(), me), 
				HttpStatus.OK
			);
	}
	
}
