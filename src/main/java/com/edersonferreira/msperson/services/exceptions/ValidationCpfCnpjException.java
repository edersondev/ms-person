package com.edersonferreira.msperson.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "CPF/CNPJ inválido")
public class ValidationCpfCnpjException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationCpfCnpjException() {
		super();
	}
	
	public ValidationCpfCnpjException(String message) {
		super(message);
	}
}
