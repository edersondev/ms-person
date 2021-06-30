package com.edersonferreira.msperson.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid person relationship")
public class RelationshipViolationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RelationshipViolationException() {
		super();
	}
	
	public RelationshipViolationException(String message) {
		super(message);
	}
}
