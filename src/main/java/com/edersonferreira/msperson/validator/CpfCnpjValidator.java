package com.edersonferreira.msperson.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.edersonferreira.msperson.annotation.CpfCnpj;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

	@Override
	public void initialize(CpfCnpj constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		ValidationCpfCnpj validationDoc = new ValidationCpfCnpj(value);
		return validationDoc.documentIsValid();
	}

}
