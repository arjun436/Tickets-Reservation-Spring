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

	private Pattern pattern;
	private Matcher matcher;

	private static final String LOGIN_PATTERN = "[a-zA-Z0-9_]{1,15}";
	private static final String PHONE_PATTERN = "\\+[0-9]{1,4}\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";

	private static final String FLIGHT_NUMBER_PATTERN = "[a-zA-Z0-9]{1,9}";
	private static final String CITY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String US_DATE_PATTERN = "(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}";// mm/dd/yyyy
	private static final String HOUR_PATTER_24 = "([01]?[0-9]|2[0-3]):[0-5][0-9]";// 24
																					// hour
																					// pattern
	private static final String PRICE_PATTERN = "[1-9]{1}[0-9]{0,10}";// PRICE

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

		String valueToCheck;
		
		ValidationUtils.rejectIfEmpty(errors, "flightNumber", "error.field.required");
		valueToCheck = planeTicket.getFlightNumber().trim();
		validateField(errors, FLIGHT_NUMBER_PATTERN, valueToCheck, "flightNumber", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightFrom", "error.field.required");
		valueToCheck = planeTicket.getFlightFrom().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "flightFrom", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightTo", "error.field.required");
		valueToCheck = planeTicket.getFlightTo().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "flightTo", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightDateStart", "error.field.required");
		valueToCheck = planeTicket.getFlightDateStart().trim();
		validateField(errors, US_DATE_PATTERN, valueToCheck, "flightDateStart", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightHourStart", "error.field.required");
		valueToCheck = planeTicket.getFlightHourStart().trim();
		validateField(errors, HOUR_PATTER_24, valueToCheck, "flightHourStart", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightDateStop", "error.field.required");
		valueToCheck = planeTicket.getFlightDateStop().trim();
		validateField(errors, US_DATE_PATTERN, valueToCheck, "flightDateStop", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightHourStop", "error.field.required");
		valueToCheck = planeTicket.getFlightHourStop().trim();
		validateField(errors, HOUR_PATTER_24, valueToCheck, "flightHourStop", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "flightPrice", "error.field.required");
		valueToCheck = planeTicket.getFlightPrice().trim();
		validateField(errors, PRICE_PATTERN, valueToCheck, "flightPrice", "error.field.invalid");

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
