package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.NotFoundException;
import com.nocountry.ecommerce.common.security.utils.JwtUtils;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.repository.RoleRepository;
import com.nocountry.ecommerce.domain.repository.UserRepository;
import com.nocountry.ecommerce.domain.usecase.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {


    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final JwtUtils jwtUtils;

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

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with the email: " + email));
    }



    @Transactional
    @Override
    public User updateUser(Long id, User user) {
      
        User userFromDb = userRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setPhone(user.getPhone());
        userFromDb.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(userFromDb);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("User not found with the id: " + id));
        userRepository.delete(user);
    }
}
