package com.jwt.security.web.controller;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.web.entity.UserDetail;
import com.jwt.security.web.response.ApiResponse;
import com.jwt.security.web.service.UserDetailService;
import com.jwt.security.web.util.JwtUtil;


@RestController
public class UserDetailController {
	
	private final JwtUtil jwtUtil;
	@Autowired
    private final UserDetailService userService;

    public UserDetailController(JwtUtil jwtUtil, UserDetailService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDetail request) {
        if (userService.validate(request.getUsername(), request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @GetMapping("/users")
    public Map<String, String> getUserData() {
        return Map.of("message", "You are authenticated!", "status", "SUCCESS");
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<ApiResponse<UserDetail>> addUserDetail(@RequestBody UserDetail userDetail) {
        UserDetail user = userService.addUser(userDetail);
        ApiResponse<UserDetail> response = new ApiResponse<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "User created successfully", user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
 // Pagination + Sorting
    @GetMapping("/byPage")
    public ResponseEntity<Page<UserDetail>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "userDetailId,asc") String[] sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort[1]), sort[0]));
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    // Filtering + Pagination + Sorting
    @GetMapping("/search")
    public ResponseEntity<Page<UserDetail>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "userDetailId,asc") String[] sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort[1]), sort[0]));
        return ResponseEntity.ok(userService.searchUsers(username, role, pageable));
    }

}
