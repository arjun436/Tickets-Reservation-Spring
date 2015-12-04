package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.PlaneTicket;

public class PlaneTicketValidator implements Validator {
	
	
	private int minPasswordLength;
	private int maxPasswordLength;
	private static String loginRegex = "[a-zA-Z]*";
	private static String digitsRegex = ".*\\p{Digit}.*";
	private static String specialCharactersRegex = ".*[!£$#%^&*@?<>+_].*";

	// phone
	private Pattern pattern;
	private Matcher matcher;
	private static final String PHONE_PATTERN = "\\+48\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";



	EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class clazz) {
		return PlaneTicket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(PlaneTicket planeTicket, Errors errors) {
		
		// czy pola sa puste
		ValidationUtils.rejectIfEmpty(errors, "flightNumber", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightFrom", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightTo", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightDateStart", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightHourStart", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightDateStop", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightHourStop", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "flightPrice", "error.field.required");
//		if (errors.getErrorCount() == 0) {
//			// czy poprawny email
//			if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false) {
//				errors.rejectValue("email", "error.email.invalid");
//			}
//
//			// walidacja czy poprawny nr telefonu
//			pattern = Pattern.compile(PHONE_PATTERN);
//			matcher = pattern.matcher(user.getTelephone().trim());
//
//			if (!matcher.matches()) {
//				errors.rejectValue("telephone", "error.telephone.invalid");
//			}
//
//			// pesel
//			if(!isPeselValid(user)){
//				errors.rejectValue("pesel", "error.pesel.invalid");
//			}
//
//		}

	}










}
