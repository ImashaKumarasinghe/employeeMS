package com.employee.employeems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class ResponseDTO {

    private String code;
    private String message;
    private Object content;

}
