package com.lead.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.Lead;
import com.lead.management.entity.LeadType;
@Repository
public interface LeadTypeRepository extends JpaRepository<LeadType, Long> {

	Optional<Lead> findByTypeName(String typeName);
	
}
