package com.common.all.required.web.global.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super();
	}
	
	 public UserNotFoundException(String message) {
	        super(message);
	    }

}
