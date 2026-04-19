package com.api.management.secure.way.dto;

import com.api.management.secure.way.entity.Role;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
	
	@NotBlank
    private String username;

    @NotBlank
    private String password;

    private Role role;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RegisterRequest(@NotBlank String username, @NotBlank String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public RegisterRequest() {
		super();
	}
    
    
}
