package com.employee.employeems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Employee")

public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//Tells JPA how the primary key value is generated.
//@Id defines the primary key, and @GeneratedValue(strategy = GenerationType.IDENTITY)
// tells the database to auto-generate the primary key using auto-increment.
    private int empId;
    private String empName;
    private String empAddress;
    private String empMNumber;
}
