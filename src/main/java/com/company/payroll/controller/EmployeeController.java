package com.company.payroll.controller;

import com.company.payroll.pojo.Employee;
import com.company.payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees")
    List<Employee> all(){
        return employeeService.getAll();
    }
    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/employee/{id}")
    Employee one(@PathVariable long id){
        return employeeService.getOne(id);
    }
    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable long id){
        employeeService.removeById(id);
    }
    @GetMapping("/getEmployee/{name}")
    Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getByName(name);
    }
    @PutMapping("/employee/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee,@PathVariable long id){
         return employeeService.updateEmployee(newEmployee,id);
    }
}
