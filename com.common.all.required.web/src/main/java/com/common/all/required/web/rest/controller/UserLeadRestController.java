package com.common.all.required.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.all.required.web.entity.UserLead;
import com.common.all.required.web.serviceimpl.UserlLeadServiceImpl;

@RestController
@RequestMapping("/api")
public class UserLeadRestController {
	
	@Autowired
	private UserlLeadServiceImpl userlLeadServiceImpl;
	
	@PostMapping("/leads")
	public ResponseEntity<UserLead> createLead(@RequestBody UserLead userLead){
		System.out.println("hhhhhhhhhhhh");
		userlLeadServiceImpl.createUserLead(userLead);
		return ResponseEntity.status(HttpStatus.CREATED).body(userLead);
	}

}
