package com.employee.employeems.repo;

import com.employee.employeems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//We extend JpaRepository<Employee, Integer> to connect the Employee entity
// with Spring Data JPA and automatically get CRUD and database operations without writing SQL.
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
