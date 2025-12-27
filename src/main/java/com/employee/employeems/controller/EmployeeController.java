package com.employee.employeems.controller;

import com.employee.employeems.dto.EmployeeDTO;
import com.employee.employeems.dto.ResponseDTO;
import com.employee.employeems.service.EmployeeService;
import com.employee.employeems.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")


public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public ResponseDTO responseDTO;

    @PostMapping(value = "/saveemployee")
    //ResponseEntity is used to return the HTTP response with full control over the
    // response body, status code, and headers.


public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){

    try {
        String res=employeeService.saveEmployee(employeeDTO);
        if(res.equals("00")){
            responseDTO.setCode(VarList.SUCCESS);
            responseDTO.setMessage("success");
            responseDTO.setContent(employeeDTO);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } else if (res.equals("03")) {
            responseDTO.setCode(VarList.DUPLICATE);
            responseDTO.setMessage("Employee Already Registered");
            responseDTO.setContent(employeeDTO);
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

        }else{
            responseDTO.setCode(VarList.ERROR);
            responseDTO.setMessage("Fail");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

        }

    } catch (Exception ex) {
        responseDTO.setCode(VarList.ERROR);
        responseDTO.setMessage(ex.getMessage());
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @PutMapping(value = "/updateemployee")
    //ResponseEntity is used to return the HTTP response with full control over the
    // response body, status code, and headers.


    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO){

        try {
            String res=employeeService.updateEmployee(employeeDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.SUCCESS);
                responseDTO.setMessage("success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals("02")) {
                responseDTO.setCode(VarList.NOT_FOUND);
                responseDTO.setMessage("Not Registered employee");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.ERROR);
                responseDTO.setMessage("Fail");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception ex) {
            responseDTO.setCode(VarList.ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
