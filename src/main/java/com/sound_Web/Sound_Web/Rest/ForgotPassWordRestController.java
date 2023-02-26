package com.sound_Web.Sound_Web.Rest;

import com.sound_Web.Sound_Web.Service.ForgotPasswordService;
import com.sound_Web.Sound_Web.Service.ResetPassImpl.ResetPassUsingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/forgotpassword")
public class ForgotPassWordRestController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @Autowired
    ResetPassUsingAccount resetPassUsingAccount;

    @GetMapping()
    public ModelAndView display_view() {
        ModelAndView mav = new ModelAndView("Contact.html");
        return mav;
    }

    @GetMapping("/Check/{info}")
    public ResponseEntity<?> CheckInfo(@RequestParam String signal, @PathVariable String info) {
        if (signal.equals("e")) {
            return ResponseEntity.ok(forgotPasswordService.CheckEmail(info));
        } else {
            return ResponseEntity.ok(forgotPasswordService.CheckUsername(info));
        }
    }

    @PostMapping("/resetPassword/{signal}/{info}")
    public void ResetPass(@PathVariable String signal, HttpServletRequest request, @PathVariable String info) {
        if (!signal.equals("e")) {
            resetPassUsingAccount.ProcessReset(info,request);
        } else {

        }
    }

}
