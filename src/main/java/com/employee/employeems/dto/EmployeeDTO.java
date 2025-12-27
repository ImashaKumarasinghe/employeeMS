package com.employee.employeems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private Integer empId;
    private String empName;
    private String empAddress;
    private String empMNumber;
}
