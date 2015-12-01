package com.mypackage.myapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mypackage.myapp.domain.Address;

public class AddressValidator implements Validator{

	 private Pattern pattern;  
	 private Matcher matcher;  
	
	 
	 private static final String ZIP_PATTERN = "[0-9]{2}-[0-9]{3}";  
	 
	 
	  @Override
	  public boolean supports(Class clazz)
	  {
	    return Address.class.isAssignableFrom(clazz);
	  }
	  @Override
	  public void validate(Object arg0, Errors arg1)
	  {
	    // TODO Auto-generated method stub
	  }
	  public void validate(Address address, Errors errors)
	  {
		  ValidationUtils.rejectIfEmpty(errors,"country", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"state", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"city", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"street", "error.field.required");
		  //ValidationUtils.rejectIfEmpty(errors,"zip", "error.field.required");
		  
//		  if (errors.getErrorCount() == 0) 
//		  	{
//
//		  	}
		  pattern = Pattern.compile(ZIP_PATTERN);  
		   matcher = pattern.matcher(address.getZip().toString().trim());  
		   
		   if(!address.getZip().matches(".*\\w.*"))//if not at lest one ascii char
			   errors.rejectValue("zip", "error.field.required"); 
		   else if (!matcher.matches()) {  
			    errors.rejectValue("zip", "error.zip.invalid");  
		   }

		  

	  }
}
