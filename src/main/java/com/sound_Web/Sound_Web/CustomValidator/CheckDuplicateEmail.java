package com.sound_Web.Sound_Web.CustomValidator;

import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateimpl.CheckDuplicateEmailIMPL;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE ,  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDuplicateEmailIMPL.class)

public @interface CheckDuplicateEmail {
    String message() default "Email Đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
