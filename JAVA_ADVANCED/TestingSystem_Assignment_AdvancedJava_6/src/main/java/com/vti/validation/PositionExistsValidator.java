package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.entity.enumerate.PositionName;
import com.vti.service.PositionService;

public class PositionExistsValidator implements ConstraintValidator<PositionExists, String> {

	private PositionService service;

	@Override
	public void initialize(PositionExists annotation) {
		service = new PositionService();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		return service.isPositionExistsByName(PositionName.of(value));
	}
}