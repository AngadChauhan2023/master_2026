package com.users.rest.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.entity.UserDetailsToken;
import com.users.jwt.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UsersAuthRestController {
	
	private static final String STATIC_USERNAME = "admin";
    private static final String STATIC_PASSWORD = "password";
	private final JwtUtil jwtUtil;

    public UsersAuthRestController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    
    
    @PostMapping("/token")
    public Map<String, String> login2(@RequestBody UserDetailsToken request) {
        String username = request.getUsername();
        String password = request.getPassword();
       // Simple user validation logic (replace with DB logic)
        // 🔐 Static user authentication
        if (STATIC_USERNAME.equals(username) && STATIC_PASSWORD.equals(password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of("token", token);
        }

        // ❌ Unauthorized
        throw new RuntimeException("Invalid username or password");
    }
}
