package com.sound_Web.Sound_Web.Event.Mail;

import com.sound_Web.Sound_Web.Model.User;
import org.springframework.context.ApplicationEvent;

public class SendEmailEventSignUp extends ApplicationEvent {
    private final User user ;

    public SendEmailEventSignUp(Object source, User user) {

        super(source);

        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
