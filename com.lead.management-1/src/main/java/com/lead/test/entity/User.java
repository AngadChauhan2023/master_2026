package com.lead.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private String name ;
	 private String email; 
	 private String MobileNo; 
	 private String City;
	 
	 public Long getId() {
		return id;
	}

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getMobileNo() {
		 return MobileNo;
	 }

	 public void setMobileNo(String mobileNo) {
		 MobileNo = mobileNo;
	 }

	 public String getCity() {
		 return City;
	 }

	 public void setCity(String city) {
		 City = city;
	 }

	

	 public User(Long id, String name, String email, String mobileNo, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		MobileNo = mobileNo;
		City = city;
	 }
	 


}
