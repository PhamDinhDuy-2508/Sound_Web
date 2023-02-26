package com.sound_Web.Sound_Web.Service;

import com.sound_Web.Sound_Web.Model.CustomerDetails;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.Respository.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserService  implements UserDetailsService {
    @Autowired
    UserResponsitory userResponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userResponsitory.findUserByAccount(username);
        if (user == null) {
            return null;
        }
        return new CustomerDetails(user);
    }

    public UserDetails loadUserById(String userid) throws UsernameNotFoundException {

        long l=Long.parseLong(userid);
        User user = userResponsitory.findByUserID(userid);
        if (user == null) {
            return null;
        }
        return new CustomerDetails(user);
    }
}
