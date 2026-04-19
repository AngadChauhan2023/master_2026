package com.users.rest.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.custom.exceptions.BadRequestException;
import com.users.custom.exceptions.ResourceNotFoundException;
import com.users.entity.ApiResponse;
import com.users.entity.UserDetails;
import com.users.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<UserDetails>> createUser(@RequestBody UserDetails userDetails){
       System.out.println("User Details Request ------------: "+userDetails);
         UserDetails user = userDetailsService.createUser(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(LocalDateTime.now(),201,"User created",user));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserDetails>> createUser1(@RequestBody UserDetails userDetails) {
        final Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("Received user creation request: {}", userDetails.toString());
        UserDetails savedUser = userDetailsService.createUser(userDetails);
        ApiResponse<UserDetails> response = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "User created successfully",
                savedUser
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/getUsers")
    public List<UserDetails> getAllUsers(){
    	List<UserDetails> allUser = userDetailsService.getAllUser();
    	if(allUser != null && !allUser.isEmpty()) {
    		return allUser;
    	}
		 throw new ResourceNotFoundException("No Records Found ! Try after some time!!");	
    }
    
    @GetMapping("/getUser")
    public ResponseEntity<ApiResponse<List<UserDetails>>> getAllUser(){
    	List<UserDetails> allUser = userDetailsService.getAllUser();
    	ApiResponse<List<UserDetails>> response = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Users fetched successfully",
                allUser
        );

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<ApiResponse<UserDetails>> getUserById(@PathVariable long userId) {
        Optional<UserDetails> userById = userDetailsService.getUserById(userId);
        if (userById.isPresent()) {
            ApiResponse<UserDetails> response = new ApiResponse<>(
                    LocalDateTime.now(),
                    HttpStatus.OK.value(),
                    "User fetched successfully",
                    userById.get()
            );
            return ResponseEntity.ok(response);
        }

        throw new ResourceNotFoundException("No user found with ID: " + userId);
    }
    
    
    @PostMapping("/created")
    public ResponseEntity<ApiResponse<UserDetails>> createUser3(@RequestBody UserDetails userDetails) {
        final Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info("Received user creation request: {}", userDetails.toString());
        if(userDetails.getFirstName() !=null) {
        	UserDetails savedUser = userDetailsService.createUser(userDetails);
            ApiResponse<UserDetails> response = new ApiResponse<>(
                    LocalDateTime.now(),
                    HttpStatus.CREATED.value(),
                    "User created successfully",
                    savedUser
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }throw new BadRequestException("Bad Request !! "+ userDetails.toString());
        
    } 
    
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<UserDetails>> searchUsers(@RequestParam String name) {
        //return ResponseEntity.ok(userDetailsService.searchByName(name));
    	Optional<UserDetails> searchByName = userDetailsService.searchByName(name);
        if (searchByName.isPresent()) {
            ApiResponse<UserDetails> response = new ApiResponse<>(
                    LocalDateTime.now(),
                    HttpStatus.OK.value(),
                    "User fetched successfully",
                    searchByName.get()
            );
            return ResponseEntity.ok(response);
        }

        throw new ResourceNotFoundException("No user found with Name : " + name);
    }
    
    @GetMapping("/users/search")
    public ResponseEntity<ApiResponse<List<UserDetails>>> getUserByName(@RequestParam String lastName) {
        List<UserDetails> user = userDetailsService.searchByLastName(lastName);
        if (user != null && !user.isEmpty()) {
        	ApiResponse<List<UserDetails>> response = new ApiResponse<List<UserDetails>>(
        	        LocalDateTime.now(),
        	        HttpStatus.OK.value(),
        	        "User(s) fetched successfully",
        	        user
        	);
            return ResponseEntity.ok(response);
        }

        throw new ResourceNotFoundException("No user found with lastName : " + lastName);
        
    }


}