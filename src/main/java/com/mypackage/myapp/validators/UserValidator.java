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
	private int minPasswordLength;
	private int maxPasswordLength;
	private static String loginRegex = "[a-zA-Z]*";
	private static String digitsRegex = ".*\\p{Digit}.*";
	private static String specialCharactersRegex = ".*[!£$#%^&*@?<>+_].*";

	// phone
	private Pattern pattern;
	private Matcher matcher;
	private static final String PHONE_PATTERN = "\\+48\\s[0-9]{3}-[0-9]{3}-[0-9]{3}";

	// pesel
	private byte PESEL[] = new byte[11];
	private boolean valid = false;

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
		// czy pola sa puste
		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "pesel", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

		if (errors.getErrorCount() == 0) {
			// czy poprawny email
			if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false) {
				errors.rejectValue("email", "error.email.invalid");
			}

			// walidacja czy poprawny nr telefonu
			pattern = Pattern.compile(PHONE_PATTERN);
			matcher = pattern.matcher(user.getTelephone().trim());

			if (!matcher.matches()) {
				errors.rejectValue("telephone", "error.telephone.invalid");
			}

			// pesel
			if(!isPeselValid(user)){
				errors.rejectValue("pesel", "error.pesel.invalid");
			}

		}

	}

	public void setMinPasswordLength(int minPasswordLength) {
		this.minPasswordLength = minPasswordLength;
	}

	public void setMaxPasswordLength(int maxPasswordLength) {
		this.maxPasswordLength = maxPasswordLength;
	}

	public boolean isPeselValid(User user) {
		String PESELNumber = user.getPesel();

		if (PESELNumber.length() != 11) {
			valid = false;
		} else {
			for (int i = 0; i < 11; i++) {
				PESEL[i] = Byte.parseByte(PESELNumber.substring(i, i + 1));
			}
			if (checkSum() && checkMonth() && checkDay()) {
				valid = true;
			} else {
				valid = false;
			}
		}
		return valid;
	}

	public int getBirthYear() {
		int year;
		int month;
		year = 10 * PESEL[0];
		year += PESEL[1];
		month = 10 * PESEL[2];
		month += PESEL[3];
		if (month > 80 && month < 93) {
			year += 1800;
		} else if (month > 0 && month < 13) {
			year += 1900;
		} else if (month > 20 && month < 33) {
			year += 2000;
		} else if (month > 40 && month < 53) {
			year += 2100;
		} else if (month > 60 && month < 73) {
			year += 2200;
		}
		return year;
	}

	public int getBirthMonth() {
		int month;
		month = 10 * PESEL[2];
		month += PESEL[3];
		if (month > 80 && month < 93) {
			month -= 80;
		} else if (month > 20 && month < 33) {
			month -= 20;
		} else if (month > 40 && month < 53) {
			month -= 40;
		} else if (month > 60 && month < 73) {
			month -= 60;
		}
		return month;
	}

	public int getBirthDay() {
		int day;
		day = 10 * PESEL[4];
		day += PESEL[5];
		return day;
	}

	public String getSex() {
		if (valid) {
			if (PESEL[9] % 2 == 1) {
				return "Mezczyzna";
			} else {
				return "Kobieta";
			}
		} else {
			return "---";
		}
	}

	private boolean checkSum() {
		int sum = 1 * PESEL[0] + 3 * PESEL[1] + 7 * PESEL[2] + 9 * PESEL[3] + 1 * PESEL[4] + 3 * PESEL[5] + 7 * PESEL[6]
				+ 9 * PESEL[7] + 1 * PESEL[8] + 3 * PESEL[9];
		sum %= 10;
		sum = 10 - sum;
		sum %= 10;

		if (sum == PESEL[10]) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkMonth() {
		int month = getBirthMonth();
		int day = getBirthDay();
		if (month > 0 && month < 13) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkDay() {
		int year = getBirthYear();
		int month = getBirthMonth();
		int day = getBirthDay();
		if ((day > 0 && day < 32)
				&& (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
			return true;
		} else if ((day > 0 && day < 31) && (month == 4 || month == 6 || month == 9 || month == 11)) {
			return true;
		} else if ((day > 0 && day < 30 && leapYear(year)) || (day > 0 && day < 29 && !leapYear(year))) {
			return true;
		} else {
			return false;
		}
	}

	private boolean leapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}
}
