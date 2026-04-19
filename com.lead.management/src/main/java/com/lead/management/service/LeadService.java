package com.lead.management.service;

import com.lead.management.entity.*;
import com.lead.management.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class LeadService {

    private final LeadRepository leadRepository;
    private final LeadTypeRepository leadTypeRepository;
    private final DeveloperSkillRepository skillRepository;

    public LeadService(LeadRepository leadRepository,
                       LeadTypeRepository leadTypeRepository,
                       DeveloperSkillRepository skillRepository) {
        this.leadRepository = leadRepository;
        this.leadTypeRepository = leadTypeRepository;
        this.skillRepository = skillRepository;
    }

    // 🔹 MAIN SAVE METHOD
    public Lead saveLead(Lead lead) {

        // 1️⃣ Identify Lead Type
        String typeName = lead.getLeadType() != null ? lead.getLeadType().getTypeName() : null;
        if (typeName == null) {
            throw new IllegalArgumentException("Lead type is required");
        }

        // 2️⃣ Ensure LeadType exists or create new
        LeadType leadType = leadTypeRepository
                .findByTypeName(typeName)
                .orElseGet(() -> leadTypeRepository.save(lead.getLeadType()));
        lead.setLeadType(leadType);

        // 3️⃣ Type-specific save logic
        switch (typeName.toLowerCase()) {
            case "enquiry" -> handleEnquiryLead(lead);
            case "contact us" -> handleContactUsLead(lead);
            case "complaint" -> handleComplaintLead(lead);
            case "hire us" -> handleHireUsLead(lead);
            case "buy course" -> handleBuyCourseLead(lead);
            default -> throw new IllegalArgumentException("Unsupported lead type: " + typeName);
        }

        // 4️⃣ Save parent Lead (cascade saves children)
        return leadRepository.save(lead);
    }

    // ---------------------- TYPE HANDLERS ----------------------

    private void handleEnquiryLead(Lead lead) {
        Enquiry enquiry = lead.getEnquiry();
        if (enquiry == null) {
            throw new IllegalArgumentException("Enquiry details are required for Enquiry lead");
        }
        enquiry.setLead(lead);
        lead.setEnquiry(enquiry);
    }

    private void handleContactUsLead(Lead lead) {
        ContactUs contact = lead.getContactUs();
        if (contact == null) {
            throw new IllegalArgumentException("ContactUs details are required for ContactUs lead");
        }
        contact.setLead(lead);
        lead.setContactUs(contact);
    }

    private void handleComplaintLead(Lead lead) {
        Complaint complaint = lead.getComplaint();
        if (complaint == null) {
            throw new IllegalArgumentException("Complaint details are required for Complaint lead");
        }
        complaint.setLead(lead);
        lead.setComplaint(complaint);
    }

    private void handleHireUsLead(Lead lead) {
        Set<DeveloperSkill> inputSkills = lead.getDeveloperSkills();
        if (inputSkills == null || inputSkills.isEmpty()) {
            throw new IllegalArgumentException("Skills are required for Hire Us lead");
        }

        Set<DeveloperSkill> attachedSkills = new HashSet<>();
        for (DeveloperSkill skill : inputSkills) {
            DeveloperSkill existing = skillRepository.findBySkillName(skill.getSkillName())
                    .orElseGet(() -> skillRepository.save(skill));
            attachedSkills.add(existing);
        }
        lead.setDeveloperSkills(attachedSkills);
    }

    private void handleBuyCourseLead(Lead lead) {
        // If future we have BuyCourse-specific table or fields, manage here.
        System.out.println("Saving Buy Course Lead...");
    }

    // ---------------------- BASIC CRUD ----------------------

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
