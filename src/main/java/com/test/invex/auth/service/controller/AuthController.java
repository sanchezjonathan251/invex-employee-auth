package com.test.invex.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.invex.auth.service.dto.AuthRequest;
import com.test.invex.auth.service.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return service.login(
                request.getUsername(),
                request.getPassword()
        );
    }
}
