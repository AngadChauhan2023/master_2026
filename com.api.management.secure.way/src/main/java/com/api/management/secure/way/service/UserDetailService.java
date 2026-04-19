package com.api.management.secure.way.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.management.secure.way.entity.User;
import com.api.management.secure.way.repository.UserRepository;

@Service
public class UserDetailService {
	
	@Autowired
	UserRepository userRepository;
	
	@Bean
	 UserDetailsService userDetailsService() {
	    return username -> {
	        User user = userRepository.findByUsername(username);

	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }

	        return org.springframework.security.core.userdetails.User.builder()
	                .username(user.getUsername())
	                .password(user.getPassword())
	                .roles(user.getRole().name().replace("ROLE_", ""))
	                .build();
	    };
	}

}
