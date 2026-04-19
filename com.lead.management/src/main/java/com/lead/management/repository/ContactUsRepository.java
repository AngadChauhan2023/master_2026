package com.lead.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.management.entity.ContactUs;
@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {}
