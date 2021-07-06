package com.edersonferreira.msperson.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid email")
public class ValidationEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidationEmailException() {
		super();
	}
	
	public ValidationEmailException(String message) {
		super(message);
	}

}
