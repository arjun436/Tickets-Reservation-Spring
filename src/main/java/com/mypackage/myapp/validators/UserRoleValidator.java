package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.UserRole;


public class UserRoleValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String LOGIN_PATTERN = "[a-zA-Z0-9_]{1,15}";

	
	EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class clazz) {
		return UserRole.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(UserRole userRole, Errors errors) {

		String valueToCheck;

		ValidationUtils.rejectIfEmpty(errors, "role", "error.field.required");
		valueToCheck = userRole.getRole();
		validateField(errors, LOGIN_PATTERN, valueToCheck, "role", "error.field.invalid");

		
		
	}

	private void validateField(Errors errors, String regexPattern, String valueToCheck, String field,
			String errorMessage) {
		pattern = Pattern.compile(regexPattern);
		matcher = pattern.matcher(valueToCheck);
		if (!matcher.matches()) {
			errors.rejectValue(field, errorMessage);

		}

	}

}
