package com.users.custom.exceptions;

public class BadRequestException extends RuntimeException {
	
	public BadRequestException(String message) {
        super(message);
    }


}
