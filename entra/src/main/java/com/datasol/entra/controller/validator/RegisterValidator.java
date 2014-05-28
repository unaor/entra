package com.datasol.entra.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.datasol.entra.domain.User;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if(user.getFirstName().isEmpty()){
			errors.rejectValue("firstName", "register.form.firstName.empty");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "register.form.lastName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "register.form.password.empty");
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())){
			errors.rejectValue("password", "register.form.password.not.equals");
		}
		
		if(!user.getAcceptedTos()){
			errors.rejectValue("acceptedTos", "register.form.TOS.false");
		}
		
		
	}

}
