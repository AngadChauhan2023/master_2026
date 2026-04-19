package com.lead.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead.test.entity.User;
import com.lead.test.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	public UserService userService;
	
	
	@PostMapping
	public User postMethodName(@RequestBody User user) {
		
		
		return userService.userDataSave(user);
	}
	
//	@DeleteMapping("/{id}")
//	public delete()
//	
	

}
