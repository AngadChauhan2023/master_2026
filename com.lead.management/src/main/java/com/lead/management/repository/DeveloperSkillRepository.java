package com.lead.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.DeveloperSkill;
import com.lead.management.entity.Lead;
@Repository
public interface DeveloperSkillRepository extends JpaRepository<DeveloperSkill, Long> {

	Optional<Lead> findBySkillName(String skillName);
	
}
