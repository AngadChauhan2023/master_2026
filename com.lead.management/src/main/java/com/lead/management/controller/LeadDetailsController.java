package com.lead.management.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead.management.entity.Lead;
import com.lead.management.repository.LeadRepository;

@RestController
@RequestMapping("/api/lead-details")
public class LeadDetailsController {

    private final LeadRepository leadRepository;

    public LeadDetailsController(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getLeadDetails(@PathVariable Long id) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("lead", lead);
        response.put("leadType", lead.getLeadType());
        response.put("enquiry", lead.getEnquiry());
        response.put("contactUs", lead.getContactUs());
        response.put("complaint", lead.getComplaint());
        response.put("comments", lead.getComments());
        response.put("skills", lead.getDeveloperSkills());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<Map<String, Object>> getAllLeadDetails() {
        List<Lead> leads = leadRepository.findAll();
        List<Map<String, Object>> list = new ArrayList<>();

        for (Lead lead : leads) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("lead", lead);
            map.put("leadType", lead.getLeadType());
            map.put("skills", lead.getDeveloperSkills());
            list.add(map);
        }
        return list;
    }
}
