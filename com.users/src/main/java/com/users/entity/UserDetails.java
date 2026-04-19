package com.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public UserDetails(long userId, String firstName, String lastName, String email, String mobileNo) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobileNo=" + mobileNo + "]";
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


}

