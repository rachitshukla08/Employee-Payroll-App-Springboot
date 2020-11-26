package com.bridgelabz.employeepayrollapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.utility.Response;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeePayrollException.class)
	public final ResponseEntity<Response> employeePayrollException(EmployeePayrollException e) {
        Response status=new Response(400,e.getMessage());
        return new ResponseEntity<Response>(status,HttpStatus.OK);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
}
