package com.mypractice.csvreader.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mypractice.csvreader.constraint.GenderTypeSubset;
import com.mypractice.csvreader.enums.GenderType;

public class GenderTypeValidator implements ConstraintValidator<GenderTypeSubset, GenderType> {
	private GenderType[] genderTypes;

	@Override
	public void initialize(GenderTypeSubset constraint) {
		this.genderTypes =constraint.anyOf();
	}


	@Override
	public boolean isValid(GenderType value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value == null || Arrays.asList(genderTypes).contains(value);
	}

}