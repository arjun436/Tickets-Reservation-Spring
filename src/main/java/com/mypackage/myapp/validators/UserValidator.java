package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.User;


public class UserValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String LOGIN_PATTERN = "[a-zA-Z0-9_]{1,15}";
	private static final String PASSWORD_PATTERN = "[a-zA-Z0-9_!£$#%^&*@?<>+]{1,25}";
	private static final String NAME_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String COUNTRY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String STATE_PATTERN = "[a-zA-Z0-9\\s]{1,25}";
	private static final String CITY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String STREET_PATTERN = "[a-zA-Z0-9\\s]{1,25}";
	private static final String PHONE_PATTERN = "\\+[0-9]{1,4}\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";
	
	EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(User user, Errors errors) {

		String valueToCheck;

		ValidationUtils.rejectIfEmpty(errors, "login", "error.field.required");
		valueToCheck = user.getLogin().trim();
		validateField(errors, LOGIN_PATTERN, valueToCheck, "login", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "password", "error.field.required");
		valueToCheck = user.getPassword().trim();
		validateField(errors, PASSWORD_PATTERN, valueToCheck, "password", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.field.required");
		valueToCheck = user.getFirstname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "firstname", "error.field.invalid");

		valueToCheck = planeTicketOrder.getSecondname().trim();
		if(valueToCheck.indexOf('a')>=0){
			validateField(errors, NAME_PATTERN, valueToCheck, "secondname", "error.field.invalid");

		}

		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.field.required");
		valueToCheck = user.getLastname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "lastname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
		valueToCheck = user.getCountry().trim();
		validateField(errors, COUNTRY_PATTERN, valueToCheck, "country", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "state", "error.field.required");
		valueToCheck = user.getState().trim();
		validateField(errors, STATE_PATTERN, valueToCheck, "state", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
		valueToCheck = user.getCity().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "city", "error.field.invalid");
		
		ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
		valueToCheck = user.getStreet().trim();
		validateField(errors, STREET_PATTERN, valueToCheck, "street", "error.field.invalid");
		
		
		ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
		// czy poprawny email
		if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false) {
			errors.rejectValue("email", "error.field.invalid");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
		valueToCheck = user.getTelephone().trim();
		validateField(errors, PHONE_PATTERN, valueToCheck, "telephone", "error.field.invalid");
		
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
