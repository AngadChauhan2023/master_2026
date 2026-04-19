package com.jwt.security.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwt.security.web.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
	
	// Filtering by username and role
    Page<UserDetail> findByUsernameAndRole(String username, String role, Pageable pageable);

}
