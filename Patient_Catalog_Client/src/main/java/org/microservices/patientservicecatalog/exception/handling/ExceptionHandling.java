package org.microservices.patientservicecatalog.exception.handling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException ) {
		
		return new ResponseEntity<String>("Value not present in the database, please change your request",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
