package com.sound_Web.Sound_Web.Service;

import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

    @Autowired
    private ValidationService validationService;

    public Boolean CheckEmail(String Email) {
        return validationService.ValidateEmail(Email);
    }

    public  Boolean  CheckUsername(String username) {
        return  validationService.ValidateUsername(username) ;
    }


}
