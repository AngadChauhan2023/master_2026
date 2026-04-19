package com.employee.management.auth.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.entity.LoginRequest;
import com.employee.management.entity.RegisterRequest;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EmployeeRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthController(EmployeeRepository repo, PasswordEncoder encoder, JwtService jwtService) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        var employee = Employee.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .role(req.getRole())
                .build();
        repo.save(employee);
        return "Employee registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        var employee = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        if (!encoder.matches(req.getPassword(), employee.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return jwtService.generateToken(employee.getUsername(), employee.getRole().name());
    }
    
}