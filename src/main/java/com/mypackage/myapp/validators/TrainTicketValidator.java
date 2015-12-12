package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.domain.TrainTicket;

public class TrainTicketValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String LOGIN_PATTERN = "[a-zA-Z0-9_]{1,15}";
	private static final String PHONE_PATTERN = "\\+[0-9]{1,4}\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";

	private static final String TRANSIT_NUMBER_PATTERN = "[a-zA-Z0-9]{1,9}";
	private static final String TRANSIT_NAME_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String CITY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String US_DATE_PATTERN = "(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}";// mm/dd/yyyy
	private static final String HOUR_PATTER_24 = "([01]?[0-9]|2[0-3]):[0-5][0-9]";// 24
																					// hour
																					// pattern
	private static final String PRICE_PATTERN = "[1-9]{1}[0-9]{0,10}";// PRICE

	@Override
	public boolean supports(Class clazz) {
		return PlaneTicket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(TrainTicket trainTicket, Errors errors) {



		String valueToCheck;

		ValidationUtils.rejectIfEmpty(errors, "transitNumber", "error.field.required");
		valueToCheck = trainTicket.getTransitNumber().trim();
		validateField(errors, TRANSIT_NUMBER_PATTERN, valueToCheck, "transitNumber", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitName", "error.field.required");
		valueToCheck = trainTicket.getTransitName().trim();
		validateField(errors, TRANSIT_NAME_PATTERN, valueToCheck, "transitName", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitFrom", "error.field.required");
		valueToCheck = trainTicket.getTransitFrom().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "transitFrom", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitTo", "error.field.required");
		valueToCheck = trainTicket.getTransitTo().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "transitTo", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitDateStart", "error.field.required");
		valueToCheck = trainTicket.getTransitDateStart().trim();
		validateField(errors, US_DATE_PATTERN, valueToCheck, "transitDateStart", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitHourStart", "error.field.required");
		valueToCheck = trainTicket.getTransitHourStart().trim();
		validateField(errors, HOUR_PATTER_24, valueToCheck, "transitHourStart", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitDateStop", "error.field.required");
		valueToCheck = trainTicket.getTransitDateStop().trim();
		validateField(errors, US_DATE_PATTERN, valueToCheck, "transitDateStop", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitHourStop", "error.field.required");
		valueToCheck = trainTicket.getTransitHourStop().trim();
		validateField(errors, HOUR_PATTER_24, valueToCheck, "transitHourStop", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "transitPrice", "error.field.required");
		valueToCheck = trainTicket.getTransitPrice().trim();
		validateField(errors, PRICE_PATTERN, valueToCheck, "transitPrice", "error.field.invalid");

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
