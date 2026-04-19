package com.jwt.security.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Managment")
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userDetailId;
	private String username;
    private String password;
    private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDetail(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public UserDetail() {
		super();
		
	}
	@Override
	public String toString() {
		return "UserDetail [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
    
}
