package com.sound_Web.Sound_Web.Service;

import com.sound_Web.Sound_Web.Model.EmailAndUsername;

import javax.servlet.http.HttpServletRequest;

public interface Resetpass {
    public EmailAndUsername getInfo(String info) ;
    public void SendEmail(String Email , HttpServletRequest requestm) ;

}
