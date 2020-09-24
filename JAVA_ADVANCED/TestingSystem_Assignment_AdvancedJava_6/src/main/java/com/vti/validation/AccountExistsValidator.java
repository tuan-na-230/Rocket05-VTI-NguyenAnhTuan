package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.service.AccountService;

public class AccountExistsValidator implements ConstraintValidator<AccountExists, Integer> {

	private AccountService service;

	@Override
	public void initialize(AccountExists annotation) {
		service = new AccountService();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

		if (value <= 0) {
			return false;
		}
		
		return service.isAccountExistsByID(value);
	}
}