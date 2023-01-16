package com.java.bookservice.Bookservices.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.bookservice.Bookservices.bean.MyErrorMessage;
import com.java.bookservice.Bookservices.exception.Bookserviceexceptions;



@ControllerAdvice
public class Exceptionhandler {

	@ExceptionHandler(Bookserviceexceptions.class)
	public ResponseEntity<MyErrorMessage> handleBookserviceexceptions(Bookserviceexceptions me){
		return new ResponseEntity<>(
				new MyErrorMessage(me.getMessage(), me), 
				HttpStatus.OK
			);
	}
	
}

