package com.lead.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueType, comment, status;
    @OneToOne 
    @JoinColumn(name = "lead_id") private Lead lead;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	@Override
	public String toString() {
		return "Complaint [id=" + id + ", issueType=" + issueType + ", comment=" + comment + ", status=" + status
				+ ", lead=" + lead + "]";
	}
	public Complaint(Long id, String issueType, String comment, String status, Lead lead) {
		super();
		this.id = id;
		this.issueType = issueType;
		this.comment = comment;
		this.status = status;
		this.lead = lead;
	}
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
