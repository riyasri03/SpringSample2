package com.example.SpringSample2.service.impl;

import com.example.SpringSample2.dto.DepartmentRequestDto;
import com.example.SpringSample2.dto.DepartmentResponseDto;


public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);
    //DepartmentResponseDto updateDepartmentId(Long id, DepartmentResponseDto departmentRequestDto);
}
