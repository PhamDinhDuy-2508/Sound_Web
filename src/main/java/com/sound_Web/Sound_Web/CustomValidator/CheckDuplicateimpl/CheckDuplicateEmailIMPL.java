package com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateimpl;

import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicate;
import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateEmail;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.Respository.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDuplicateEmailIMPL implements CheckDuplicate , ConstraintValidator<CheckDuplicateEmail ,  String> {
    @Autowired
    private UserResponsitory userResponsitory  ;
    @Override
    public Boolean check(String Key) {
        User value = userResponsitory.findUserByEmail(Key) ;
        if(value == null) {
            return  true ;
        }
        else {
            return false ;
        }
    }
    @Override
    public void initialize(CheckDuplicateEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return check(value);
    }
}
