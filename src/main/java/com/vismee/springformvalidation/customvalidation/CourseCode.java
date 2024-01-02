package com.vismee.springformvalidation.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom validation annotation
// CourseCodeConstraintValidator - helper class which provides custom logic for validation
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode
{
    // Two parameters we can provide while using custom annotation - value,message

    // if the value is not provided, uses default one
    public String value() default "VIME";

    // if the message is not provided, uses default one
    public String message() default "course code must start with VIME";

    // to group related constraints together
    public Class<?>[] groups() default {};

    // to provide additional information about validation failure - severity level, error codes etc.,
    public Class<? extends Payload>[] payload() default {};
}
