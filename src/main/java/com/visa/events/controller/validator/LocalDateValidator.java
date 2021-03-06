package com.visa.events.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateValidator implements ConstraintValidator<LocalDateConstraint, String> {


    private static final Logger LOGGER = LoggerFactory.getLogger(EventTypeValidator.class);


    @Override
    public void initialize(LocalDateConstraint targetEnum) {

    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LOGGER.info("Received LocalDate {} ", value);

            LocalDate input = LocalDate.parse(value);

            //return true if it is today date or future date
            return input.isAfter(LocalDate.now()) || input.isEqual(LocalDate.now());
        } catch (Exception e) {
            //ignore
        }
        return false;
    }
}
