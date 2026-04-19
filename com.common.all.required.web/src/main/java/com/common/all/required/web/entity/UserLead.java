package com.common.all.required.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_lead")
public class UserLead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userLeadId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String contactNo;
	
	public long getUserLeadId() {
		return userLeadId;
	}
	public void setUserLeadId(long userLeadId) {
		this.userLeadId = userLeadId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public UserLead(long userLeadId, String firstName, String lastName, String emailAddress, String contactNo) {
		super();
		this.userLeadId = userLeadId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
	}
	public UserLead() {
		super();
		
	}
	@Override
	public String toString() {
		return "UserLead [userLeadId=" + userLeadId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", contactNo=" + contactNo + "]";
	}
	
	
	

}
