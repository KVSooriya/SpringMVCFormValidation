package com.vismee.springformvalidation.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Helper class where we can provide our own business logic for validation
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    // prefix that we need to validate against
    private String prefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        prefix = theCourseCode.value();
    }

    // this is the method where we provide our custom logic
    @Override
    public boolean isValid(String formString, ConstraintValidatorContext constraintValidatorContext)
    {
        if(formString!=null) {
            boolean result = formString.startsWith(prefix);
            return result;
        }
        return true;
    }
}
