package com.lead.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.Enquiry;
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {}
