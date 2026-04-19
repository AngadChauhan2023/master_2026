package com.api.management.secure.way.entity;

/*Use for auth response here created Getter, Setter, toString, All Args Constructors*/

public class AuthResponse {
	
	private String accessToken;
    private String refreshToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@Override
	public String toString() {
		return "AuthResponse [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}
	public AuthResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	public AuthResponse() {
		super();
	}
    
    

}
