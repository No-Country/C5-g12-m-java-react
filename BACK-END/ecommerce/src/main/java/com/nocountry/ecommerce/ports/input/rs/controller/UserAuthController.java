package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.common.security.utils.JwtUtils;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.usecase.UserService;
import com.nocountry.ecommerce.ports.input.rs.mapper.UserMapper;
import com.nocountry.ecommerce.ports.input.rs.request.AuthRequest;
import com.nocountry.ecommerce.ports.input.rs.request.RegisterRequest;
import com.nocountry.ecommerce.ports.input.rs.response.AuthResponse;
import com.nocountry.ecommerce.ports.input.rs.response.RegisterResponse;
import com.nocountry.ecommerce.ports.input.rs.response.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.AUTHENTICATION_URI;

@RequestMapping(AUTHENTICATION_URI)
@RestController
public class UserAuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {

        User createdUser = userService.createUser(userMapper.registerRequestToUser(registerRequest));
        UserDetailResponse userDetailResponse = userMapper.userToCreateUserResponse(createdUser);
        AuthResponse authResponse = new AuthResponse(userService.login(createdUser.getEmail(), registerRequest.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterResponse(userDetailResponse, authResponse));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authenticationRequest) {
        AuthResponse authResponse = new AuthResponse(userService.login(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDetailResponse> getUserDetail(@AuthenticationPrincipal User user) {

        UserDetailResponse userDetailResponse = userMapper.userToUserDetailResponse(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDetailResponse);
    }

}
