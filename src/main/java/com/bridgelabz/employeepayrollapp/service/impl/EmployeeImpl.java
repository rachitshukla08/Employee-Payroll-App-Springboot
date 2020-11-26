package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.Employee;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.repository.EmpRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.utility.Response;

@Service
public class EmployeeImpl implements IEmployee{
	
	@Autowired
	private EmpRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Response addEmployee(EmployeePayrollDTO employeeDTO) {
		Employee employeeExist = employeeRepository.findByEmail(employeeDTO.getEmail());
		if(employeeExist!=null) {
			throw new EmployeePayrollException(402,"Record already exists");
		}
		Employee employee = mapper.map(employeeDTO, Employee.class);
		employeeRepository.save(employee);
		return new Response(200, "Added: " +employee); 
	}

	@Override
	public Response getEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		return new Response(200,"Employees in repository: "+employeeList);
	}

	@Override
	public Response getEmployeeByID(Long id) {
		Employee employee =  employeeRepository.findById(id).get();
		if(employee!=null) {
			return new Response(200,"Employee found: "+employee);
		}
		else 
			return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void update(Long id, Long salary) {
//		Employee employee = empRepo.findById(id).get();
//		employee.setSalary(salary);
//		this.addEmployee(employee);
	}
}
