package com.company.payroll.repository;

import com.company.payroll.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByName(String name);
}
