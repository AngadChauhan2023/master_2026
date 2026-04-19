package com.lead.management.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "developer_skills")
public class DeveloperSkill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    @ManyToMany(mappedBy = "developerSkills") private Set<Lead> leads;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Set<Lead> getLeads() {
		return leads;
	}
	public void setLeads(Set<Lead> leads) {
		this.leads = leads;
	}
	public DeveloperSkill(Long id, String skillName, Set<Lead> leads) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.leads = leads;
	}
	public DeveloperSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeveloperSkill [id=" + id + ", skillName=" + skillName + ", leads=" + leads + "]";
	}
    
}
