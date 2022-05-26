package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.NotFoundException;
import com.nocountry.ecommerce.common.security.utils.JwtUtils;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.repository.RoleRepository;
import com.nocountry.ecommerce.domain.repository.UserRepository;
import com.nocountry.ecommerce.domain.usecase.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    private final static String ROLE_USER = "USER";


    @Override
    public User createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new AlreadyExistsException("User with this email already exists");
        }

        user.setRole(roleRepository.findByName(ROLE_USER).orElseThrow((() -> new NotFoundException("Role not found"))));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    @Override
    public String login(String email, String password) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        return jwtUtils.generateToken(userDetails);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userFromDb = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        if (user.getFirstName() != null) {
            userFromDb.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null) {
            userFromDb.setLastName(user.getLastName());
        }

        if (user.getPhone() != null) {
            userFromDb.setPhone(user.getPhone());
        }

        if (user.getPassword() != null) {
            userFromDb.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }
}
