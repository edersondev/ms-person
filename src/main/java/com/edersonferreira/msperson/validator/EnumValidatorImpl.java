package com.edersonferreira.msperson.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.edersonferreira.msperson.annotation.EnumValidator;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String>{

	List<String> valueList = null;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value != null) {
			return valueList.contains(value.toUpperCase());			
		}
		return true;
    }
	
	@Override
    public void initialize(EnumValidator constraintAnnotation) {
        valueList = new ArrayList<String>();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

        @SuppressWarnings("rawtypes")
        Enum[] enumValArr = enumClass.getEnumConstants();

        for (@SuppressWarnings("rawtypes") Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }
    }
}
