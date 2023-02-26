package com.sound_Web.Sound_Web.Service;

import com.sound_Web.Sound_Web.Event.SendEmailEventSignUp;
//import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.DTO.SignUp;
import com.sound_Web.Sound_Web.Respository.UserResponsitory;
import com.sound_Web.Sound_Web.Event.sendMailServiceSignUp;
import com.sound_Web.Sound_Web.Respository.solr.ValidationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;

@Service

public class SignUpService {

    @Autowired
    UserResponsitory userResponsitory;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ValidationRespository validationRespository;

    @Autowired
    sendMailServiceSignUp sendMailServiceSignUp;


    @Async
    @Transactional
    public void SignUp(SignUp signUp) {

        User user1 = new User();

        user1.setAccount(signUp.getUsername());
        user1.setPassword(signUp.getPassword());
        user1.setEmail(signUp.getEmail());


        int random_int = (int) Math.floor(Math.random() * (50000000 - 1 - +1) + 1);


        EmailAndUsername emailAndUsername = new EmailAndUsername();
        emailAndUsername.setEmail(signUp.getEmail());
        emailAndUsername.setId(random_int);
        emailAndUsername.setName(signUp.getUsername());

        userResponsitory.save(user1);

        validationRespository.save(emailAndUsername);

        applicationEventPublisher.publishEvent(new SendEmailEventSignUp(this, user1));

    }

    @Async
    @EventListener
    public void SendMailSignUp(SendEmailEventSignUp sendEmailEventSignUp) throws MessagingException, UnsupportedEncodingException {

        sendMailServiceSignUp.Send(sendEmailEventSignUp.getUser().getEmail());

    }
}
