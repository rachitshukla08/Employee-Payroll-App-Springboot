package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayrollapp.dto.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {
	Employee findByEmail(String email);
}
