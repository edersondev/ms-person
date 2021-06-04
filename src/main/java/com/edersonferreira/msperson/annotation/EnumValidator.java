package com.edersonferreira.msperson.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;

import com.edersonferreira.msperson.validator.EnumValidatorImpl;

@Constraint(validatedBy = {EnumValidatorImpl.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@NotNull
@ReportAsSingleViolation
@Documented
public @interface EnumValidator {
	Class<? extends Enum<?>> enumClass();
	String message() default "Value is not valid";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
