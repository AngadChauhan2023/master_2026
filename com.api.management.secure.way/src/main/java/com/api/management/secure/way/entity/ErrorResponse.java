package com.api.management.secure.way.entity;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String message;

	public ErrorResponse(LocalDateTime timestamp, String status, String error, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}
}
