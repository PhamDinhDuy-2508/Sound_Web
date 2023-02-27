package com.sound_Web.Sound_Web.Event.Mail;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;
import java.time.Clock;

public class SendEmailResetPassEvent extends ApplicationEvent {

    private String email;

    private String token;

    private HttpServletRequest request;

    public SendEmailResetPassEvent(Object source, String email, String token, HttpServletRequest request) {
        super(source);
        this.email = email;
        this.token = token;
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
