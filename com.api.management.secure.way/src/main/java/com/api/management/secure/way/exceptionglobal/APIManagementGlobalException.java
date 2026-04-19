package com.api.management.secure.way.exceptionglobal;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.api.management.secure.way.customException.NoAPIManagmentRecordFoundException;
import com.api.management.secure.way.customException.UserAlreadyExistException;
import com.api.management.secure.way.customException.UserNotFoundException;
import com.api.management.secure.way.entity.ErrorResponse;

@ControllerAdvice
public class APIManagementGlobalException{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> userNotFoundEx(UserNotFoundException userNotFoundException){
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString(), "User Not Found!", userNotFoundException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> userAlreadyExist(UserAlreadyExistException userAlreadyExistException){
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.ALREADY_REPORTED.toString(), "User Already Existed!", userAlreadyExistException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(NoAPIManagmentRecordFoundException.class)
	public ResponseEntity<ErrorResponse> noAPIManagementRecordFounds(NoAPIManagmentRecordFoundException noAPIManagmentRecordFound){
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString(), "No API Managements Records Founde ! ", noAPIManagmentRecordFound.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach(error ->errors.put(error.getField(), error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(errors);
	}

}
