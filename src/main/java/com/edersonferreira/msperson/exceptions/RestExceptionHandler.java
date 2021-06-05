package com.edersonferreira.msperson.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edersonferreira.msperson.model.controlleradvice.MethodArgumentNotValid;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public MethodArgumentNotValid handleNotValidException(MethodArgumentNotValidException ex) {
		
		MethodArgumentNotValid responseMsg = new MethodArgumentNotValid();
		
		BindingResult bindingResult = ex.getBindingResult();
		for (ObjectError error : bindingResult.getAllErrors()) {
			FieldError field = (FieldError) error;
			responseMsg.setMessage(field.getField(),error.getDefaultMessage());
		}
		
		return responseMsg;
	}
}
