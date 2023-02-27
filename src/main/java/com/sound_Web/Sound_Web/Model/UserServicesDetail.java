package com.sound_Web.Sound_Web.Model;

import com.sound_Web.Sound_Web.Repository.UserResponsitory;
import com.sound_Web.Sound_Web.Service.Login.UserDetailsImpl;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServicesDetail implements UserDetailsService {
    @Autowired
    ValidationService validationService;
    @Autowired
    UserResponsitory userResponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userResponsitory.findUserByAccount(username) ;
        if(user == null) {
            throw  new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return UserDetailsImpl.build(user);
    }
}

