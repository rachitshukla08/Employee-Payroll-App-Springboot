package com.bridgelabz.employeepayrollapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.service.IEmployee;
import com.bridgelabz.employeepayrollapp.utility.Response;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployee empService;
	
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<Response> getEmployeePayrollData(){
		Response response = empService.getEmployees();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getEmployeePayrollData(@PathVariable("id") long id){
		Response response = empService.getEmployeeByID(id);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Response> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeeDto){
		Response response = empService.addEmployee(employeeDto);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Updated Employee Payroll Data For: "+empPayrollDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteEmployeePayrollData(@PathVariable("id")long id){
		Response response = empService.deleteEmployee(id);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}

}
