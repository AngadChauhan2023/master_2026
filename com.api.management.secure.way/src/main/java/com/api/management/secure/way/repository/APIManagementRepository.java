package com.api.management.secure.way.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.management.secure.way.entity.APIManagement;

@Repository
public interface APIManagementRepository extends JpaRepository<APIManagement, Long> {
	
	/* Here we can write our custom finder and custom query */
	boolean existsByUserName(String userName);
	APIManagement findByUserName(String userName);
	Optional<APIManagement> findByApiManagementId(long apiManagementId);

}
