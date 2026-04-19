package com.users.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ProtectedRestController {
	@GetMapping("/welcome")
    public String secured(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return "Welcome " + username + "! This is a protected API.";
    }

    
}
