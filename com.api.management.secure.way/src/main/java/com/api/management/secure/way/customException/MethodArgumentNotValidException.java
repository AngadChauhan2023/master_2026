package com.api.management.secure.way.customException;

public class MethodArgumentNotValidException extends RuntimeException {
	public MethodArgumentNotValidException(String message) {
		super(message);
	}
}
