package com.company.payroll.service;

import com.company.payroll.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee addEmployee(Employee employee);
    Employee getOne(long id);
    void removeById(long id);
    Employee getByName(String name);
    Employee updateEmployee(Employee employee,long id);
}
