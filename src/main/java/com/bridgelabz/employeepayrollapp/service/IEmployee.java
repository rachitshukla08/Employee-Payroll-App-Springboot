package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.Employee;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.utility.Response;

public interface IEmployee {
	public Response addEmployee(EmployeePayrollDTO employeeDTO);
	public List<Employee> getEmployee();
	public Employee getEmployeeByID(Long id);
	public void deleteEmployee(Long id);
	public void update(Long id, Long salary);
}
