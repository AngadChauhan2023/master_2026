package com.users.entity;

public class UserDetailsToken {
	private String username;
    private String password;
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
	@Override
	public String toString() {
		return "UserDetailsToken [username=" + username + ", password=" + password + "]";
	}
	public UserDetailsToken(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserDetailsToken() {
		super();
		
	}


}
