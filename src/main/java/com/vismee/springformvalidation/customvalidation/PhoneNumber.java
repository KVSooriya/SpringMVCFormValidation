package com.vismee.springformvalidation.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber
{
    public String message() default "Invalid Phone number";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
