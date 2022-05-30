package com.nocountry.ecommerce.common.security.services;

import com.nocountry.ecommerce.common.security.utils.Jwt;
import com.nocountry.ecommerce.common.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtil;

    public Jwt login(String email, String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return jwtUtil.generateJwt(userDetails);
    }
}
