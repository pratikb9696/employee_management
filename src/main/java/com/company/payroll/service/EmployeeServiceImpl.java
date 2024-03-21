package com.company.payroll.service;

import com.company.payroll.pojo.Employee;
import com.company.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public Employee getOne(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void removeById(long id) {
      employeeRepository.deleteById(id);
    }

    @Override
    public Employee getByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee updateEmployee(Employee newEmployee, long id) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return employeeRepository.save(employee);
        }).orElseGet(() ->{
            newEmployee.setId(id);
            return employeeRepository.save(newEmployee);
        });
    }

}
