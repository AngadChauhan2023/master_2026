package com.api.management.secure.way.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.management.secure.way.customException.UserAlreadyExistException;
import com.api.management.secure.way.customException.UserNotFoundException;
import com.api.management.secure.way.entity.APIManagement;
import com.api.management.secure.way.repository.APIManagementRepository;

@Service
public class APIManagementService {
	
	@Autowired
	private APIManagementRepository apiManagementRepository;
	
	public APIManagement saveApiManagement(APIManagement apiManagement) {
		APIManagement apiManagementSave = null; 
		try {
			if(apiManagement != null) {
				apiManagementSave = apiManagementRepository.save(apiManagement);
			}else {
				System.out.println("!..apiManagement is null or empty...!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excepetion during insert data in DB + "+ e.getMessage());
		}
		return apiManagementSave;
	}
	
	public List<APIManagement> getApiManagementsList(){
		List<APIManagement> apiManagementsList = null;
		try {
			apiManagementsList = apiManagementRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excepetion during fetch data from DB + "+ e.getMessage());
		}
		return apiManagementsList;
	}
	
	public APIManagement updateApiManagement(APIManagement apiManagement) {
		APIManagement updateApiManagemnts = null;
		try {
			if(apiManagement != null) {
				long apiManagementId = apiManagement.getApiManagementId();
				Optional<APIManagement> apiManagementById = apiManagementRepository.findById(apiManagementId);
				if(apiManagementById.isPresent()) {
					apiManagement.setUserName(apiManagement.getUserName());
					apiManagement.setEmail(apiManagement.getEmail());
					apiManagement.setCity(apiManagement.getCity());
					apiManagement.setMobileNo(apiManagement.getMobileNo());
					return updateApiManagemnts = apiManagementRepository.save(apiManagement);
				}else {
					System.out.println("No record found with this Id : + "+ apiManagementId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excepetion during update record in DB + "+ e.getMessage());
		}
		return updateApiManagemnts;
	}
	
	public void deleteApiManagement(long apiManagementId) {
		try {
			if(apiManagementId != 0) {
				apiManagementRepository.deleteById(apiManagementId);
			}else {
				System.out.println("No record found with this Id : + "+ apiManagementId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excepetion during delete record from DB + "+ e.getMessage());
		}
	}

	
	/*
	 * Here we are re-creating all CRUD method using with Custom Exception and
	 * Global Exception Handling
	 */
	
	public APIManagement createApiManagement(APIManagement apiManagement) {
		String userName = apiManagement.getUserName();
		if(apiManagementRepository.existsByUserName(userName)) {
			throw new UserAlreadyExistException(String.format("User already exists with username: %s", userName));
		}
		return apiManagementRepository.save(apiManagement);
	}
	
	public APIManagement getByUserName(String userName) {
		APIManagement byUserName = null;
		if(!apiManagementRepository.existsByUserName(userName)) {
			throw new UserNotFoundException(String.format("User not found with username: %s", userName));
		}else {
			 byUserName = apiManagementRepository.findByUserName(userName);
		}
		return byUserName;
	}
}
