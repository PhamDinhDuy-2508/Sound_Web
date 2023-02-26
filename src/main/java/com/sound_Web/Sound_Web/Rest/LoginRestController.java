package com.sound_Web.Sound_Web.Rest;

import com.sound_Web.Sound_Web.DTO.Login;
import com.sound_Web.Sound_Web.DTO.LoginResponse;
import com.sound_Web.Sound_Web.DTO.SignUp;

import com.sound_Web.Sound_Web.Service.LoginService;
import com.sound_Web.Sound_Web.Service.SignUpService;
import com.sound_Web.Sound_Web.Service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/login")

public class LoginRestController {
    @Autowired
    LoginService loginService;
    @Autowired
    SignUpService signUpService;

    @Autowired
    ValidationService validationService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {

        LoginResponse loginResponse = loginService.LoginService(login.getAccount(), login.getPassword());
        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping("/signup")
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?> SignUp(@RequestBody SignUp signUp) {

        signUpService.SignUp(signUp);

        return new ResponseEntity<>(HttpStatus.OK);
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
