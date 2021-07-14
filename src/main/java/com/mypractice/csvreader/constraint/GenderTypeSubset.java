package com.mypractice.csvreader.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mypractice.csvreader.enums.GenderType;
import com.mypractice.csvreader.validator.GenderTypeValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = GenderTypeValidator.class)
public @interface GenderTypeSubset {

    GenderType[] anyOf();
    String message() default "gender must be any of {anyOf} instean of male or female";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}