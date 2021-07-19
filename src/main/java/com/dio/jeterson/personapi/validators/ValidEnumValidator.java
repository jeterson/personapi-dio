package com.dio.jeterson.personapi.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum, Enum<?>>{

    private Pattern pattern;
    
    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        try {
			pattern = Pattern.compile(constraintAnnotation.regexp());
		} catch (PatternSyntaxException  e) {
			throw new IllegalArgumentException("Given regex is invalid", e);
		}

    }
    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
			return true;
		}

		Matcher m = pattern.matcher(value.name());
		return m.matches();

    }

    
    
}
