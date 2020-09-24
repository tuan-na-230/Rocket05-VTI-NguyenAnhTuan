package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.entity.enumerate.SalaryName;
import com.vti.service.SalaryService;

public class SalaryExistsValidator implements ConstraintValidator<SalaryExists, String> {

	private SalaryService service;

	@Override
	public void initialize(SalaryExists annotation) {
		service = new SalaryService();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		return service.isSalaryExistsByName(SalaryName.of(value));
	}
}