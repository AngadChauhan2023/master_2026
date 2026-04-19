package com.employee.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByUsername(String username);
	boolean existsByUsername(String username);
}
