package com.sound_Web.Sound_Web.Service.ResetPassImpl;

import com.sound_Web.Sound_Web.Event.SendEmailEventSignUp;
import com.sound_Web.Sound_Web.Event.SendEmailResetPassEvent;
import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import com.sound_Web.Sound_Web.Service.Resetpass;
import com.sound_Web.Sound_Web.Service.ValidationService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Qualifier("ResetPassUsingAccount")
@EnableCaching
public class ResetPassUsingAccount {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ValidationService validationService;

    public EmailAndUsername getInfo(String info) {
        return validationService.getByUserName(info);
    }

    public void SendEmail(String Email, HttpServletRequest request) {

        String token = RandomString.make(45);

        while (checkTokenExist(token)) {
            token = RandomString.make(45);
        }
        redisTemplate.opsForValue().set(token, Email);

        redisTemplate.expire(token, 20, TimeUnit.MINUTES);

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
