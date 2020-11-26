package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.utility.Response;

public interface IEmployee {
	public Response addEmployee(EmployeePayrollDTO employeeDTO);
	public Response getEmployees();
	public Response getEmployeeByID(Long id);
	public void deleteEmployee(Long id);
	public void update(Long id, Long salary);
}
