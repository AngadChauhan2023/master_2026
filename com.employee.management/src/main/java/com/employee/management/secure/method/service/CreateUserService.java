package com.employee.management.secure.method.service;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;

@Service
public class CreateUserService {
	private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(EmployeeRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee createUser(Employee user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
    
    public Optional<Employee> findByUserName(String employee) {
    	Optional<Employee> byUsername = repository.findByUsername(employee);
		return byUsername;
    }

}
