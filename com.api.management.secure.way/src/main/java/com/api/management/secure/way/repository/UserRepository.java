package com.api.management.secure.way.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.management.secure.way.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
