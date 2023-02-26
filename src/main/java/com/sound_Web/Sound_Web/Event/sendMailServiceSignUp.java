package com.sound_Web.Sound_Web.Event;

import com.sound_Web.Sound_Web.Event.SendEmailEventSignUp;
import com.sound_Web.Sound_Web.POJO.Utility;
import com.sound_Web.Sound_Web.Service.SendMailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class sendMailServiceSignUp {

    @Autowired
    JavaMailSender javaMailSender;


    public void Send(String email) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("duypham258138@gmail.com", "CKT Support");
        helper.setTo(email);
        String subject = "Chào mừng bạn đến với trang web của chúng tôi";

        String content = "<p>Xin Chào</p>"
                + "<p>Bạn đã đăng ký thành công vào trang web của chúng tôi</p>" +
                "<p>Chúc bạn có một trải nghiệm tốt nhất</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        javaMailSender.send(message);
        //AccountList
    }
    @Async
    @Transactional
    @EventListener
    public  void RestPassListenser(SendEmailResetPassEvent sendEmailResetPassEvent) throws MessagingException, UnsupportedEncodingException {
        String resetPasswordLink = Utility.getSiteURL(sendEmailResetPassEvent.getRequest()) + "/reset_pass?token=" + sendEmailResetPassEvent.getToken();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("duypham258138@gmail.com", "CKT Support");

        helper.setTo(sendEmailResetPassEvent.getEmail());

        String subject = "Here's the link to reset your password";

        String content = "<p>Xin Chào</p>"
                + "<p>Bạn đã yêu cầu reset mật khẩu của bạn cho chúng tôi</p>"
                + "<p>Bạn hãy click vào đường link dưới đây để có thể thay đổi mật khẩu của bạn</p>"
                + "<p><a href=" + resetPasswordLink + ">Change my password</a></p>"
                + "<br>"
                + "<p> Bỏ qua thư này nếu bạn đã nhớ lại được mật khẩu"
                + "Hoặc bạn không có ý định nhận thư này.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        javaMailSender.send(message);

    }
}
