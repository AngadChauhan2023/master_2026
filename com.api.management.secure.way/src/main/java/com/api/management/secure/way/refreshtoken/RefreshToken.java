package com.api.management.secure.way.refreshtoken;

import java.time.Instant;
import com.api.management.secure.way.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="RefreshToken_")
public class RefreshToken {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Instant expiryDate;

    @OneToOne
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RefreshToken(Long id, String token, Instant expiryDate, User user) {
		super();
		this.id = id;
		this.token = token;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	public RefreshToken() {
		super();
	}

	@Override
	public String toString() {
		return "RefreshToken [id=" + id + ", token=" + token + ", expiryDate=" + expiryDate + ", user=" + user + "]";
	}
    
    

}
