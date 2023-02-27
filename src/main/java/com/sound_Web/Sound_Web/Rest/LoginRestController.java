package com.sound_Web.Sound_Web.Rest;

import com.sound_Web.Sound_Web.DTO.Login;
import com.sound_Web.Sound_Web.DTO.LoginResponse;

import com.sound_Web.Sound_Web.Model.CustomerDetails;
import com.sound_Web.Sound_Web.Security.JWT.JwtTokenProvider;
import com.sound_Web.Sound_Web.Service.Login.LoginService;
import com.sound_Web.Sound_Web.Service.Login.SignUpService;
import com.sound_Web.Sound_Web.Service.User.CustomUserDetails;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/login")

public class LoginRestController {
    @Autowired
    LoginService loginService;
    @Autowired
    SignUpService signUpService;
    @Autowired
    AuthenticationManager authenticationManager ;

    @Autowired
    JwtTokenProvider tokenProvider ;

    @Autowired
    ValidationService validationService;


    @PostMapping("/signin")

    public ResponseEntity<?> login(@RequestBody Login login , HttpServletRequest httpServletRequest) {
        LoginResponse loginResponse = loginService.LoginService(login.getAccount(), login.getPassword());
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getAccount() ,
                        login.getPassword()
                )
        ) ;
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal()) ;
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(()->{
                httpServletRequest.getSession().setAttribute(login.getAccount(), jwt);
                return null;
        }) ;
        return ResponseEntity.ok("asd");
    }





}
