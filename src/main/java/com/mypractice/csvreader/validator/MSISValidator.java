package com.mypractice.csvreader.validator;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mypractice.csvreader.dto.ErrorDto;
import com.mypractice.csvreader.util.ObjectUtilMapper;

@Component
public class MSISValidator {
	private final Validator validator;

	@Autowired
	public MSISValidator(Validator validator) {
		super();
		this.validator = validator;
	}

	public <S, D> List<ErrorDto> validateMsisObject(final S objectSource, Class<D> validateClass) {

		return validator.validate(ObjectUtilMapper.map(objectSource, validateClass)).parallelStream()
				.map(MSISValidator::getErrorDetails).collect(Collectors.toList());
	}

	public static ErrorDto getErrorDetails(ConstraintViolation<?> constraintViolation) {
		return ErrorDto.builder().errorDescription(constraintViolation.getMessage())
				.fieldName(constraintViolation.getPropertyPath().toString()).build();
	}
}
