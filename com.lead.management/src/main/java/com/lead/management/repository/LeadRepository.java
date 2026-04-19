package com.lead.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.Lead;
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
	
}
