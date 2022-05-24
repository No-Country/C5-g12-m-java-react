package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.usecase.UserService;
import com.nocountry.ecommerce.ports.input.rs.mapper.UserMapper;
import com.nocountry.ecommerce.ports.input.rs.request.UpdateUserRequest;
import com.nocountry.ecommerce.ports.input.rs.response.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.USER_URI;

@RequestMapping(USER_URI)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PutMapping("{id}")
    public ResponseEntity<UserDetailResponse> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequest userUpdate) {
        User user = userService.updateUser(id, userMapper.updateUserRequestToUser(userUpdate));
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.userToUserDetailResponse(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
