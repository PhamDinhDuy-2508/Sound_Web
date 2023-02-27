package com.sound_Web.Sound_Web.Rest;

import com.sound_Web.Sound_Web.DTO.SignUp;
//import com.sound_Web.Sound_Web.Security.JWT.JwtTokenProvider;
import com.sound_Web.Sound_Web.DTO.TokenDTO;
import com.sound_Web.Sound_Web.Service.Login.SignUpService;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/Sound_Web")
public class SignUp_REST {
    @Autowired
    SignUpService signUpService;

//    @Autowired
//    JwtTokenProvider tokenProvider;

    @Autowired
    ValidationService validationService;

    @PostMapping("/signUp")
    public void  SignUp(SignUp signUp) {
        System.out.println(123123123);
        signUpService.SignUp(signUp);
    }

    @GetMapping("/validateUsername/{username}")
    public CompletableFuture<Boolean> validateUsername(@PathVariable("username") String username) {

        Logger logger = Logger.getLogger(LoginRestController.class.getName());
        logger.info(Thread.currentThread().getName());

        CompletableFuture<Boolean> completableFuture =
                (CompletableFuture<Boolean>) CompletableFuture.supplyAsync(() -> validationService.ValidateUsername(username));

        return completableFuture.thenApply(bool -> {
            return bool;
        });
    }

    @GetMapping("/validateEmail/{Email}")
    public CompletableFuture<Boolean> ValidateEmail(@PathVariable("Email") String Email) {

        CompletableFuture<Boolean> completableFuture =
                CompletableFuture.supplyAsync(() -> validationService.ValidateEmail(Email));

        return completableFuture.thenApply(bool -> {
            return bool;
        });
    }
}
