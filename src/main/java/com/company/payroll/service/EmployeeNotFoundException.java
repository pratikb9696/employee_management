package com.company.payroll.service;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("Employee Not Found for Id: "+id);
    }
}
