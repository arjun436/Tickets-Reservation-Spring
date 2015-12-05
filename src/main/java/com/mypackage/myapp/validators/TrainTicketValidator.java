package com.mypackage.myapp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.domain.TrainTicket;

public class TrainTicketValidator implements Validator {
	

	@Override
	public boolean supports(Class clazz) {
		return PlaneTicket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
	}

	public void validate(TrainTicket TrainTicket, Errors errors) {
		
		// czy pola sa puste
		ValidationUtils.rejectIfEmpty(errors, "transitNumber", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitName", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitFrom", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitTo", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitDateStart", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitHourStart", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitDateStop", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitHourStop", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "transitPrice", "error.field.required");
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
