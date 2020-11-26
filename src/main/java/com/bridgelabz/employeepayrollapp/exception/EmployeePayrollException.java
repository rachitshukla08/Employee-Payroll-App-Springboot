package com.bridgelabz.employeepayrollapp.exception;

public class EmployeePayrollException extends RuntimeException {
	
	int errorCode;
	String message;
	
	public EmployeePayrollException(String message) {
		super(message);
	}
	public EmployeePayrollException(int errorCode,String message) {
		this(message);
		this.errorCode = errorCode;
	}
}
