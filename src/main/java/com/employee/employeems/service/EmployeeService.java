package com.employee.employeems.service;

import com.employee.employeems.dto.EmployeeDTO;
import com.employee.employeems.entity.Employee;
import com.employee.employeems.repo.EmployeeRepo;
import com.employee.employeems.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    //DTOs are used in the service layer to transfer data
    // safely between layers without exposing the database entity.
    //EmployeeDTO is the data type (class),
    // and employeeDTO is the variable that holds the object passed to the method.
    public String saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmpId() != null && employeeRepo.existsById(employeeDTO.getEmpId())) {
            return VarList.DUPLICATE;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmpId() != null && employeeRepo.existsById(employeeDTO.getEmpId())) {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.SUCCESS;
        } else {
            return VarList.NOT_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList,
                new TypeToken<ArrayList<EmployeeDTO>>() {
                }.getType());
    }

    public EmployeeDTO searchEmployee(Integer empId) {
        if (employeeRepo.existsById(empId)) {
            Employee employee = employeeRepo.findById(empId).get();
            return modelMapper.map(employee, EmployeeDTO.class);
        } else {
            return null;
        }
    }

}
