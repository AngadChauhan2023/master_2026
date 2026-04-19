package com.api.management.secure.way.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.management.secure.way.dto.LoginRequest;
import com.api.management.secure.way.dto.RegisterRequest;
import com.api.management.secure.way.entity.ApiResponse;
import com.api.management.secure.way.entity.AuthResponse;
import com.api.management.secure.way.jwtservice.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
            @Valid @RequestBody RegisterRequest request) {

        AuthResponse response = service.register(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        LocalDateTime.now(),
                        201,
                        "User registered successfully",
                        response
                ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @RequestBody LoginRequest request) {

        AuthResponse response = service.login(request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        LocalDateTime.now(),
                        200,
                        "Login successful",
                        response
                )
        );
    }
}
