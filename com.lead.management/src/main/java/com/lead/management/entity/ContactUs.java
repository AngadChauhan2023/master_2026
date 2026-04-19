package com.lead.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_us")
public class ContactUs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purposeOfContact, comment;
    @OneToOne 
    @JoinColumn(name = "lead_id") private Lead lead;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurposeOfContact() {
		return purposeOfContact;
	}
	public void setPurposeOfContact(String purposeOfContact) {
		this.purposeOfContact = purposeOfContact;
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
	public ContactUs(Long id, String purposeOfContact, String comment, Lead lead) {
		super();
		this.id = id;
		this.purposeOfContact = purposeOfContact;
		this.comment = comment;
		this.lead = lead;
	}
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", purposeOfContact=" + purposeOfContact + ", comment=" + comment + ", lead="
				+ lead + "]";
	}
    
}
