package com.sound_Web.Sound_Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String Login_Page() {
        return "login-cover.html" ;
    }

    @RequestMapping("/SignUp")
    public String SignUp() {
        return "Sign_Up.html" ;
    }





}
