package com.lead.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.Complaint;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {}
