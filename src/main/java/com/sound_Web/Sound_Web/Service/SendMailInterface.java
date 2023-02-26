package com.sound_Web.Sound_Web.Service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
public interface SendMailInterface {
    public void Send(String email) throws MessagingException, UnsupportedEncodingException;
}
