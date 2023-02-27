package com.sound_Web.Sound_Web.Rest;

import com.sound_Web.Sound_Web.DTO.ConfirmEmailDTO;
import com.sound_Web.Sound_Web.DTO.PasswordDTO;
import com.sound_Web.Sound_Web.Service.ResetPassImpl.ResetPassWordService;
import com.sound_Web.Sound_Web.Service.User.UserService;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/Sound_Web")
public class ForgotPassword {
    @Autowired
    UserService userService;
    @Autowired
    ResetPassWordService resetPassWordService;
    @Autowired
    ValidationService validationService;

    @GetMapping("/Confirm")
    public ResponseEntity<Boolean> ConfirmEmail(@RequestBody ConfirmEmailDTO confirmEmailDTO) {
        return ResponseEntity.ok(validationService.ValidateEmail(confirmEmailDTO.getEmail()));
    }

    @PostMapping("/sendEmailConfirm")
    public void SendEmailConfirm(@RequestBody ConfirmEmailDTO confirmEmailDTO, HttpServletRequest httpServletRequest) {
        resetPassWordService.SendEmail(confirmEmailDTO.getEmail(), httpServletRequest);
    }

    @PutMapping("/UpdatePassword/{id}")
    public void UpdatePassWord(@RequestBody PasswordDTO passwordDTO, @PathVariable String id) {
            userService.UpdatePassWord(Integer.parseInt(id) , passwordDTO.getPassWord());
    }

}
