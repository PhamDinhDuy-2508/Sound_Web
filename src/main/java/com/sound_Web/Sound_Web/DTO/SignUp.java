package com.sound_Web.Sound_Web.DTO;

import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateAccount;
import com.sound_Web.Sound_Web.CustomValidator.CheckDuplicateEmail;
import lombok.Data;

@Data
public class SignUp {
    String username ;
    String password ;
    String email ;
}
