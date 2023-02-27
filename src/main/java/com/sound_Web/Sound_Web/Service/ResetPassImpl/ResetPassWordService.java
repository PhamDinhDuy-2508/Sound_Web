package com.sound_Web.Sound_Web.Service.ResetPassImpl;

import com.sound_Web.Sound_Web.Event.Mail.SendEmailResetPassEvent;
import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.Repository.UserResponsitory;
import com.sound_Web.Sound_Web.Security.JWT.JwtTokenProvider;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Qualifier("ResetPassUsingAccount")
@EnableCaching
public class ResetPassWordService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ValidationService validationService;
    @Autowired
    UserResponsitory userResponsitory;

    @Autowired
    JwtTokenProvider tokenProvider;


    public EmailAndUsername getInfo(String info) {
        return validationService.getByUserName(info);
    }

    @Async
    public void SendEmail(String Email, HttpServletRequest request) {
        User user = userResponsitory.findUserByEmail(Email);
        String token = tokenProvider.generateToken(String.valueOf(user.getUserID()));
        applicationEventPublisher.publishEvent(new SendEmailResetPassEvent(this, Email, token, request));
    }

    public boolean checkTokenExist(String token) {
        try {
            Object object = redisTemplate.opsForValue().get(token);
            if (object == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
    @Async
    public void ProcessReset(String info, HttpServletRequest request) {
        String email = getInfo(info).getEmail();
        SendEmail(email, request);
    }
}
