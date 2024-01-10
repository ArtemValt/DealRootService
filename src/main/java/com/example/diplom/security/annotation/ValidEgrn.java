package com.example.diplom.security.annotation;

import com.example.diplom.security.validation.EgrnValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EgrnValidation.class)
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface ValidEgrn {

    String message() default "This isn't correct";

    Class[] groups() default {};

    Class[] payload() default {};
}