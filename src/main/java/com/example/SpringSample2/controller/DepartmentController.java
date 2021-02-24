package com.example.SpringSample2.controller;

import com.example.SpringSample2.dto.DepartmentRequestDto;

import com.example.SpringSample2.dto.DepartmentResponseDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;
import com.example.SpringSample2.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //POST - /employee
    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }
}
