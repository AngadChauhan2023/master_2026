package com.api.management.secure.way.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.management.secure.way.refreshtoken.RefreshToken;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

}
