package com.api.management.secure.way.exceptionglobal;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.management.secure.way.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse<String>> handleException(RuntimeException ex) {

		return ResponseEntity.badRequest().body(new ApiResponse<>(LocalDateTime.now(), 400, ex.getMessage(), null));
	}
}