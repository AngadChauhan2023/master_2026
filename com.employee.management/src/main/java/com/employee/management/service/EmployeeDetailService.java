package com.employee.management.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeDetailService implements UserDetailsService{
	
	private final EmployeeRepository repository;

    public EmployeeDetailService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var employee = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found !! "));

        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .roles(employee.getRole().name())
                .build();
    }

}
