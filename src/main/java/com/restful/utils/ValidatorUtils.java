package com.restful.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;


@Component
public class ValidatorUtils {

    private final Validator validator;

    public ValidatorUtils(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object obj) throws ConstraintViolationException {
        Set<ConstraintViolation<Object>> result = validator.validate(obj);;
        if(!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
    }
}
