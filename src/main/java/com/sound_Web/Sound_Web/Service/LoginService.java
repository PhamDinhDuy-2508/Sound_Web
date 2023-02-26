package com.sound_Web.Sound_Web.Service;

import com.sound_Web.Sound_Web.JWT.JwtTokenProvider;
import com.sound_Web.Sound_Web.Model.CustomerDetails;
import com.sound_Web.Sound_Web.Model.User;
import com.sound_Web.Sound_Web.DTO.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    User user;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public LoginResponse LoginService(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken((CustomerDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

}
