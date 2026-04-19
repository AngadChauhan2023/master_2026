package com.api.management.secure.way.customException;

public class UserNotFoundException extends RuntimeException {
	
 public UserNotFoundException(String message) {
	 super(message);
 }
}
