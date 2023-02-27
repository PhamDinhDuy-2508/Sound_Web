package com.sound_Web.Sound_Web.Service.User;

import com.sound_Web.Sound_Web.Model.CustomerDetails;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.Repository.UserResponsitory;
import com.sound_Web.Sound_Web.Service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("service")
public class UserService  implements UserDetailsService {
    @Autowired
    UserResponsitory userResponsitory;
    @Autowired
    ValidationService validationService ;

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
    @Async
    public void UpdatePassWord(int id , String passWord){
        userResponsitory.updatePassword(passWord , id) ;
    }
}
