package com.api.management.secure.way.repository;

import java.util.List;
import com.api.management.secure.way.entity.APIManagement;

public interface APIManagementNoAuthService {
	
	List<APIManagement> getAllAPIManagements();
	APIManagement getById(long apiManagementId);
	APIManagement updateAPIManagement(long apiManagementId, APIManagement apiManagement);

}
