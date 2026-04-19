package com.lead.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiries")
public class Enquiry {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purpose, comment;
    @OneToOne 
    @JoinColumn(name = "lead_id") private Lead lead;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	public Enquiry(Long id, String purpose, String comment, Lead lead) {
		super();
		this.id = id;
		this.purpose = purpose;
		this.comment = comment;
		this.lead = lead;
	}
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Enquiry [id=" + id + ", purpose=" + purpose + ", comment=" + comment + ", lead=" + lead + "]";
	}
    
}
