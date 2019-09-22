package com.binay.microservices.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
