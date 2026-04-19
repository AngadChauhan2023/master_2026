package com.employee.management.secure.method.service;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Secured("ROLE_MANAGER")
    public String generateReport() {
        return "Report generated!";
    }
}
