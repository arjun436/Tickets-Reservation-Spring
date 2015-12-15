package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.domain.TrainTicketOrder;

public class OrderValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;


	private static final String NAME_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String COUNTRY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String STATE_PATTERN = "[a-zA-Z0-9\\s]{1,25}";
	private static final String CITY_PATTERN = "[a-zA-Z\\s]{1,25}";
	private static final String STREET_PATTERN = "[a-zA-Z0-9\\s]{1,25}";
	private static final String PHONE_PATTERN = "\\+[0-9]{1,4}\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";

	EmailValidator emailValidator = EmailValidator.getInstance();

	@Override
	public boolean supports(Class clazz) {
		return (PlaneTicketOrder.class.isAssignableFrom(clazz) && TrainTicketOrder.class.isAssignableFrom(clazz));
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(PlaneTicketOrder planeTicketOrder, Errors errors) {

		String valueToCheck;

		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.field.required");
		valueToCheck = planeTicketOrder.getFirstname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "firstname", "error.field.invalid");

		valueToCheck = planeTicketOrder.getSecondname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "secondname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.field.required");
		valueToCheck = planeTicketOrder.getLastname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "lastname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
		valueToCheck = planeTicketOrder.getCountry().trim();
		validateField(errors, COUNTRY_PATTERN, valueToCheck, "country", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "state", "error.field.required");
		valueToCheck = planeTicketOrder.getState().trim();
		validateField(errors, STATE_PATTERN, valueToCheck, "state", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
		valueToCheck = planeTicketOrder.getCity().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "city", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
		valueToCheck = planeTicketOrder.getStreet().trim();
		validateField(errors, STREET_PATTERN, valueToCheck, "street", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
		// czy poprawny email
		if (StringUtils.hasText(planeTicketOrder.getEmail()) && emailValidator.isValid(planeTicketOrder.getEmail()) == false) {
			errors.rejectValue("email", "error.field.invalid");
		}

		ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
		valueToCheck = planeTicketOrder.getTelephone().trim();
		validateField(errors, PHONE_PATTERN, valueToCheck, "telephone", "error.field.invalid");

	}

	public void validate(TrainTicketOrder trainTicketOrder, Errors errors) {

		String valueToCheck;

		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.field.required");
		valueToCheck = trainTicketOrder.getFirstname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "firstname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "secondname", "error.field.required");
		valueToCheck = trainTicketOrder.getSecondname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "secondname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.field.required");
		valueToCheck = trainTicketOrder.getLastname().trim();
		validateField(errors, NAME_PATTERN, valueToCheck, "lastname", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
		valueToCheck = trainTicketOrder.getCountry().trim();
		validateField(errors, COUNTRY_PATTERN, valueToCheck, "country", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "state", "error.field.required");
		valueToCheck = trainTicketOrder.getState().trim();
		validateField(errors, STATE_PATTERN, valueToCheck, "state", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
		valueToCheck = trainTicketOrder.getCity().trim();
		validateField(errors, CITY_PATTERN, valueToCheck, "city", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
		valueToCheck = trainTicketOrder.getStreet().trim();
		validateField(errors, STREET_PATTERN, valueToCheck, "street", "error.field.invalid");

		ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
		// czy poprawny email
		if (StringUtils.hasText(trainTicketOrder.getEmail()) && emailValidator.isValid(trainTicketOrder.getEmail()) == false) {
			errors.rejectValue("email", "error.field.invalid");
		}

		ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
		valueToCheck = trainTicketOrder.getTelephone().trim();
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
