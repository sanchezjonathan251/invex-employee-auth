package com.test.invex.auth.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.invex.auth.service.entity.User;
import com.test.invex.auth.service.repository.UserRepository;
import com.test.invex.auth.service.service.AuthService;
import com.test.invex.auth.service.util.JwtUtil;


@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private JwtUtil jwtUtil;


	@Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
       
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}