package com.api.management.secure.way.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class APIManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long apiManagementId;
	
	@NotBlank(message ="User Name can not be blank")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Username must contain only letters")
	private String userName;
	
	@NotBlank(message="Email Id can not be blank")
	@Email(message="Invalid Email id, Please enter valid email")
	private String email;
	
	private String city;
	private String mobileNo;
	public long getApiManagementId() {
		return apiManagementId;
	}
	public void setApiManagementId(long apiManagementId) {
		this.apiManagementId = apiManagementId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public APIManagement(long apiManagementId, String userName, String email, String city, String mobileNo) {
		super();
		this.apiManagementId = apiManagementId;
		this.userName = userName;
		this.email = email;
		this.city = city;
		this.mobileNo = mobileNo;
	}
	public APIManagement() {
		super();
	}
	@Override
	public String toString() {
		return "APIManagement [apiManagementId=" + apiManagementId + ", userName=" + userName + ", email=" + email
				+ ", city=" + city + ", mobileNo=" + mobileNo + "]";
	}
	
	

}
