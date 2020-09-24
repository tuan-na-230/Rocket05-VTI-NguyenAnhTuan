package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mysql.cj.util.StringUtils;
import com.vti.service.AccountService;

public class UsernameNotExistsValidator implements ConstraintValidator<UsernameNotExists, String> {
	
	private AccountService service;

	public void initialize(UsernameNotExists annotation) {
		service = new AccountService();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isNullOrEmpty(value)) {
			return true;
		}

		return !service.isAccountExistsByUsername(value);
	}

}
