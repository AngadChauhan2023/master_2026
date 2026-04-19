package com.api.management.secure.way.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.management.secure.way.entity.APIManagement;
import com.api.management.secure.way.entity.ApiResponse;
import com.api.management.secure.way.service.APIManagementNoAuthServiceImpl;
import com.api.management.secure.way.service.APIManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/no")
public class APIManagementNoAuthRestController {
	private static final Logger logger = LoggerFactory.getLogger(APIManagementNoAuthRestController.class);
	@Autowired
	private APIManagementService apiManagementService;
	
	@Autowired
	APIManagementNoAuthServiceImpl apiManagementNoAuthServiceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<APIManagement>> createAPIManagement(@Valid @RequestBody APIManagement apiManagement){
		APIManagement saveApiManagement = apiManagementService.createApiManagement(apiManagement);
		ApiResponse<APIManagement> apiResponse = new ApiResponse<APIManagement>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Record created sucessfully", saveApiManagement);
		logger.info(": Record save successfully : " + saveApiManagement);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	@GetMapping("/byUserName")
	public ResponseEntity<ApiResponse<APIManagement>> getByUserName(@Valid @RequestParam String userName){
		APIManagement byUserName = apiManagementService.getByUserName(userName);
		ApiResponse<APIManagement> apiResponse = new ApiResponse<APIManagement>(LocalDateTime.now(), HttpStatus.OK.value(), "Record fetched sucessfully", byUserName);
		logger.info(": Record fetched successfully : " + byUserName);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@GetMapping("/getAPIManagement")
	public ResponseEntity<ApiResponse<List<APIManagement>>> getAPIManagementList(){
		 List<APIManagement> allAPIManagements = apiManagementNoAuthServiceImpl.getAllAPIManagements();
		 ApiResponse<List<APIManagement>> apiResponse = new ApiResponse<List<APIManagement>>(LocalDateTime.now(), HttpStatus.OK.value(), "API Management Record fetched sucessfully", allAPIManagements);
		 return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@GetMapping("/getAPIManagmentById")
	public ResponseEntity<ApiResponse<APIManagement>> getAPIManagementById(@Valid @RequestParam long apiManagementId){
		APIManagement byId = apiManagementNoAuthServiceImpl.getById(apiManagementId);
		ApiResponse<APIManagement> apiResponse = new ApiResponse<APIManagement>(LocalDateTime.now(), HttpStatus.OK.value(), "API Management Record fetched sucessfully :", byId);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}
	
	@PutMapping("/update/{apiManagementId}")
	public ResponseEntity<ApiResponse<APIManagement>> updateAPIManagement(@PathVariable long apiManagementId, @Valid @RequestBody APIManagement apiManagement){
		APIManagement updateAPIManagement = apiManagementNoAuthServiceImpl.updateAPIManagement(apiManagementId, apiManagement);
		ApiResponse<APIManagement> apiResponse = new ApiResponse<APIManagement>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Record updated sucessfully", updateAPIManagement);
		logger.info(": Record updated successfully : " + updateAPIManagement);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}
	
	@DeleteMapping("/delete/{apiManagementId}")
	public ResponseEntity<ApiResponse<Long>> deleteApiManagement(@PathVariable long apiManagementId){
		apiManagementNoAuthServiceImpl.deleteApiManagement(apiManagementId);
		ApiResponse<Long> apiResponse = new ApiResponse<Long>(LocalDateTime.now(), HttpStatus.OK.value(), "API Management Record deleted sucessfully :", apiManagementId);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		
	}
}
