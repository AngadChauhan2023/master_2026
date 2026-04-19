package com.api.management.secure.way.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.management.secure.way.entity.APIManagement;
import com.api.management.secure.way.service.APIManagementService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/noAuth")
public class APIManagementRestController {

	@Autowired
	private APIManagementService apiManagementService;
	
	@PostMapping("/saveApiManagement")
	public ResponseEntity<APIManagement> createApiManagement(@Valid @RequestBody APIManagement apiManagement) {
		APIManagement saveApiManagement = apiManagementService.saveApiManagement(apiManagement);
		System.out.println(": Record save successfully : " + saveApiManagement);
		return ResponseEntity.ok().body(saveApiManagement);	
	}
}
