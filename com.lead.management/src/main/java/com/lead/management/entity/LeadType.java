package com.lead.management.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead_types")
public class LeadType {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    @OneToMany(mappedBy = "leadType") private List<Lead> leads;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<Lead> getLeads() {
		return leads;
	}
	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
	public LeadType(Long id, String typeName, List<Lead> leads) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.leads = leads;
	}
	public LeadType() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LeadType [id=" + id + ", typeName=" + typeName + ", leads=" + leads + "]";
	}
    
}
