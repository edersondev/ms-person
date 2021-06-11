package com.edersonferreira.msperson.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edersonferreira.msperson.model.controlleradvice.MethodArgumentNotValid;
import com.edersonferreira.msperson.model.controlleradvice.ResponseMsg;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;
import com.edersonferreira.msperson.services.exceptions.ValidationCpfCnpjException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public MethodArgumentNotValid HandleNotValidException(MethodArgumentNotValidException ex) {
		
		MethodArgumentNotValid responseMsg = new MethodArgumentNotValid();
		
		BindingResult bindingResult = ex.getBindingResult();
		for (ObjectError error : bindingResult.getAllErrors()) {
			FieldError field = (FieldError) error;
			responseMsg.setMessage(field.getField(),error.getDefaultMessage());
		}
		
		return responseMsg;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseMsg HandleNotFoundException(ResourceNotFoundException ex) {
		ResponseMsg response = new ResponseMsg(ex.getMessage());
		return response;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseMsg HandleConstraintViolationException(ConstraintViolationException ex) {
		String violationMsg = ex.getConstraintViolations().stream().findFirst().get().getMessage();
		ResponseMsg response = new ResponseMsg(violationMsg);
		return response;
	}
	
	@ExceptionHandler(ValidationCpfCnpjException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseMsg handleValidationCpfCnpjException(ValidationCpfCnpjException ex) {
		ResponseMsg response = new ResponseMsg(ex.getMessage());
		return response;
	}
}
