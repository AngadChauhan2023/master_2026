package com.lead.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead.test.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
