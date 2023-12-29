package com.matheusport.project01.resources.exceptions;




//--(IMPORTS)--//
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheusport.project01.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

import java.time.Instant;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


//--(END)--//


@ControllerAdvice
public class ResourceExceptionHandle {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException ,HttpServletRequest httpServletRequest){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), resourceNotFoundException.getMessage(), error, httpServletRequest.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	
	
	
	
	
}
