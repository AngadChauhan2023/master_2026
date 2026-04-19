package com.employee.management.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.secure.method.service.CreateUserService;

@RestController
@RequestMapping("/api/users")
public class CreateUserRestController {
	private final CreateUserService service;
	@Autowired
	private EmployeeRepository employeeRepository;

    public CreateUserRestController(CreateUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody Employee user) {
    	Employee saved = service.createUser(user);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/byName")
    public ResponseEntity<?> currentUser(@RequestParam String username) {
        return service.findByUserName(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
