package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class EmployeePayrollDTO {
	
	@NotNull
	@Size(min = 2,message = "Name should have atleast 2 characters")
	public String name;
	public long salary;
	public String email;
	
	public EmployeePayrollDTO(String name,long salary,String email) {
		this.name = name;
		this.salary = salary;
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
