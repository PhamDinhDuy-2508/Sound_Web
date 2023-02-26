package com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateimpl;

import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicate;
import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateAccount;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.Respository.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckDuplicateAccountIMPL implements CheckDuplicate , ConstraintValidator<CheckDuplicateAccount, String> {

    @Autowired
    private UserResponsitory userResponsitory ;

    @Override
    public Boolean check(String Key) {

        User value = userResponsitory.findUserByAccount(Key) ;
        if(value == null) {
            return  false ;
        }
        else {
            return true ;
        }
    }

    @Override
    public void initialize(CheckDuplicateAccount constraintAnnotation) {

        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return check(value);
    }
}

