package com.sound_Web.Sound_Web.Service.Validation;

import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import com.sound_Web.Sound_Web.Repository.solr.ValidationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;
@Service
public class ValidationService {
    @Autowired
    private ValidationRespository validationRespository;

    public Boolean ValidateUsername(String username) {

        Logger logger = Logger.getLogger(ValidationService.class.getName());
        logger.info(Thread.currentThread().getName());
        EmailAndUsername emailAndUsername = validationRespository.findByName(username);
        return emailAndUsername != null;

    }

    public Boolean ValidateEmail(String email) {

        EmailAndUsername emailAndUsername = validationRespository.findByEmail(email);
        return emailAndUsername != null;
        
    }

    public EmailAndUsername getByUserName(String username) {
        return  validationRespository.findByName(username);
    }
    @Transactional
    @Async
    public Boolean updateUserInfomation(String id , String passWord) {
        return true ;
    }



}
