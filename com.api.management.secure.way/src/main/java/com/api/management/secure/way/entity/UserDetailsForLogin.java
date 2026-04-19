package com.api.management.secure.way.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserDetails_")
public class UserDetailsForLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userDetailsId;
	private String firstName;
	private String lastName;
	private String userName;
	private String role;
	private String mobileNo;
	private Date createDate;
	private Date modifiedDate;
	public long getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(long userDetailsId) {
		this.userDetailsId = userDetailsId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public UserDetailsForLogin(long userDetailsId, String firstName, String lastName, String userName, String role,
			String mobileNo, Date createDate, Date modifiedDate) {
		super();
		this.userDetailsId = userDetailsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
		this.mobileNo = mobileNo;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}
	public UserDetailsForLogin() {
		super();
	}
	
	
	
	

}
