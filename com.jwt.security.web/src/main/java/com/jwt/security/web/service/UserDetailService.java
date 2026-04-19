package com.jwt.security.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jwt.security.web.entity.UserDetail;
import com.jwt.security.web.repository.UserDetailRepository;

@Service
public class UserDetailService {

	@Autowired
	UserDetailRepository userDetailRepository;
   
	private final Map<String, UserDetail> users = Map.of(
	        "admin", new UserDetail("admin", "admin123", "ROLE_ADMIN"),
	        "user", new UserDetail("user", "user123", "ROLE_USER")
	    );

    
	    public UserDetail getByUsername(String username) {
	        return users.get(username);
	    }

	    public boolean validate(String username, String password) {
	    	UserDetail user = getByUsername(username);
	        return user != null && user.getPassword().equals(password);
	    }
	    
	    public UserDetail addUser(UserDetail userDetail) {
	    	return userDetailRepository.save(userDetail);
	    }
	    
	    public Page<UserDetail> getAllUsers(Pageable pageable) {
	        return userDetailRepository.findAll(pageable);
	    }

	    public Page<UserDetail> searchUsers(String username, String role, Pageable pageable) {
	        // Use empty string if filter is null
	        return userDetailRepository.findByUsernameAndRole(username != null ? username : "",role != null ? role : "",pageable);
	    }
	   
}
