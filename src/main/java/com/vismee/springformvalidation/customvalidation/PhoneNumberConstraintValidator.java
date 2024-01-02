package com.vismee.springformvalidation.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber,String>
{

    @Override
    public void initialize(PhoneNumber thePhoneNumber) {
        ConstraintValidator.super.initialize(thePhoneNumber);
    }

    @Override
    public boolean isValid(String formString, ConstraintValidatorContext constraintValidatorContext) {
        if(formString!=null)
        {
            int length = formString.length();
            boolean result = (length == 10) && (formString.startsWith("7") || formString.startsWith("8") || formString.startsWith("9"));
            return result;
        }
        return true;
    }
}
