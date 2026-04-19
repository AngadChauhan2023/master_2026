package com.employee.management.secure.method.service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAccount(Long id) {
        return "Account " + id + " deleted!";
    }
}