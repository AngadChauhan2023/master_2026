package com.lead.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead.test.entity.User;
import com.lead.test.repository.UserRepo;
@Service
public class UserService {
	@Autowired
	public UserRepo userRepo;
	
	public User userDataSave(User user) {
		
		try {
			return userRepo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public  User userDelete(Long id) {
		  userRepo.deleteById(id);
		  return null;
	}
	
	
	public Optional<User> getData(Long id) {
		Optional<User> userById = userRepo.findById(id);
		return userById;
	}
	
	public List<User> getUserList(){
		List<User> userList = userRepo.findAll();
		return userList;
	}
	

	
	public User update(Long id,User user) {
		user.setCity(user.getCity());
		user.setEmail(user.getEmail());
		user.setMobileNo(user.getMobileNo());
		user.setName(user.getName());
		return userRepo.save(user);
		
	}
}
