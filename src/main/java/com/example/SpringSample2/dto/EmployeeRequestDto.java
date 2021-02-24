package com.example.SpringSample2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {

        private long id;
        private String name;
        private DepartmentRequestDto department;



}
