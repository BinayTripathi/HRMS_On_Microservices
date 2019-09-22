package com.binay.microservices.webservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RestControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception
	{
		CommonExceptionResponse commonExceptionResponse = new  CommonExceptionResponse();
		commonExceptionResponse.setDetails(request.getDescription(false));
		commonExceptionResponse.setMessage(ex.getMessage());
		commonExceptionResponse.setTimestamp(new Date());
		return new ResponseEntity(commonExceptionResponse , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public final ResponseEntity<Object> handlePersonNotFound(Exception ex, WebRequest request) throws Exception
	{
		CommonExceptionResponse commonExceptionResponse = new  CommonExceptionResponse();
		commonExceptionResponse.setDetails(request.getDescription(false));
		commonExceptionResponse.setMessage(ex.getMessage());
		commonExceptionResponse.setTimestamp(new Date());
		return new ResponseEntity(commonExceptionResponse , HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CommonExceptionResponse commonExceptionResponse = new  CommonExceptionResponse();
		commonExceptionResponse.setDetails(request.getDescription(false));
		commonExceptionResponse.setMessage(ex.getMessage());
		commonExceptionResponse.setTimestamp(new Date());
		
		return new ResponseEntity(commonExceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
