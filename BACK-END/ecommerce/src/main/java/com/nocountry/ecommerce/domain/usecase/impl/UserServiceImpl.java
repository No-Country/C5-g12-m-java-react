package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.domain.usecase.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Bean needed to implement UserDetailsService on JwtFilterRequest. Further implementation is needed
        return null;
    }
}
