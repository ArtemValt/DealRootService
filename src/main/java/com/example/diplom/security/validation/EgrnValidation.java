package com.example.diplom.security.validation;

import com.example.diplom.security.annotation.ValidEgrn;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EgrnValidation implements ConstraintValidator<ValidEgrn, String> {

    @Override
    public void initialize(ValidEgrn constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }
}