package com.users.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.users.entity.UserDetails;
import com.users.repository.UserDetailsRepository;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails createUser(UserDetails userDetails){
        return  userDetailsRepository.save(userDetails);
    }

    public List<UserDetails> getAllUser(){
        return  userDetailsRepository.findAll();
    }
    
    public Optional<UserDetails> getUserById(long userId) {
		return userDetailsRepository.findById(userId);
    }
    
    public Optional<UserDetails> searchByName(String firstName){
    	Optional<UserDetails> byFirstName = userDetailsRepository.findByFirstName(firstName);
    	return byFirstName;
    }
    
    public List<UserDetails> searchByLastName(String lastName){
    	return userDetailsRepository.findByLastName(lastName);
    }
}