package com.api.management.secure.way.customException;

public class UserAlreadyExistException extends RuntimeException {
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
}
