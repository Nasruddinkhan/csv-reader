package com.mypractice.csvreader.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mypractice.csvreader.constraint.SimTypeSubset;
import com.mypractice.csvreader.enums.SimType;

public class SimTypeValidator implements ConstraintValidator<SimTypeSubset, SimType> {
	private SimType[] simTypes;

	@Override
	public void initialize(SimTypeSubset constraint) {
		this.simTypes = constraint.anyOf();
	}

	@Override
	public boolean isValid(SimType value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value == null || Arrays.asList(simTypes).contains(value);
	}

}
