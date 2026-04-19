package com.api.management.secure.way.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.management.secure.way.customException.NoAPIManagmentRecordFoundException;
import com.api.management.secure.way.customException.UserNotFoundException;
import com.api.management.secure.way.entity.APIManagement;
import com.api.management.secure.way.repository.APIManagementNoAuthService;
import com.api.management.secure.way.repository.APIManagementRepository;

@Service
public class APIManagementNoAuthServiceImpl implements APIManagementNoAuthService {

	private final APIManagementRepository apiManagementRepository;
	
	public APIManagementNoAuthServiceImpl(APIManagementRepository apiManagementRepository) {
		this.apiManagementRepository = apiManagementRepository;
	}


	@Override
	public List<APIManagement> getAllAPIManagements() {
		List<APIManagement> apiManagmentList = apiManagementRepository.findAll();
		if(apiManagmentList.isEmpty()) {
			throw new NoAPIManagmentRecordFoundException(String.format("No API Management Record Founde : %s", apiManagmentList));
		}
		return apiManagmentList;
	}


	@Override
	public APIManagement getById(long apiManagementId) {
		return apiManagementRepository.findByApiManagementId(apiManagementId).orElseThrow(()-> new UserNotFoundException(String.format("No API Management found with ID: %d", apiManagementId)));
	}
	
	
	public APIManagement updateAPIManagement(long apiManagementId, APIManagement apiManagement) {
	    APIManagement existingAPI = apiManagementRepository.findById(apiManagementId).orElseThrow(() -> new UserNotFoundException(String.format("No API Management found with ID: %d", apiManagementId)));
	    existingAPI.setUserName(apiManagement.getUserName());
	    existingAPI.setCity(apiManagement.getCity());
	    existingAPI.setEmail(apiManagement.getEmail());
	    existingAPI.setMobileNo(apiManagement.getMobileNo());
	    return apiManagementRepository.save(existingAPI);
	}
	
	public void deleteApiManagement(long apiManagementId) {
		APIManagement apiManagement = apiManagementRepository.findById(apiManagementId).orElseThrow(() -> new UserNotFoundException(String.format("No API Management found with ID: %d", apiManagementId)));
		apiManagementRepository.delete(apiManagement);
	}
}
