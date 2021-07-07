package com.edersonferreira.msperson.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid email")
public class ContactContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ContactContentException() {
		super();
	}
	
	public ContactContentException(String message) {
		super(message);
	}

}
