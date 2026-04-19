package com.employee.management.secure.method.service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import jakarta.annotation.security.RolesAllowed;

@Service
public class UserService {

    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    public String viewProfile() {
        return "Profile details shown!";
    }
    
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String getUserData() {
        return "This is user data accessible by USER or ADMIN.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminData() {
        return "This is admin data accessible only by ADMIN.";
    }
}
