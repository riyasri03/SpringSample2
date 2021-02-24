package com.example.SpringSample2.service.impl;


import com.example.SpringSample2.dto.DepartmentRequestDto;
import com.example.SpringSample2.dto.DepartmentResponseDto;
import com.example.SpringSample2.dto.EmployeeRequestDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;
import com.example.SpringSample2.entity.Department;

import com.example.SpringSample2.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto){
        Department department= new Department();
        BeanUtils.copyProperties(departmentRequestDto , department);
        Department saveddepartment= departmentRepository.save(department);

        DepartmentResponseDto responseDto= new DepartmentResponseDto();
        BeanUtils.copyProperties(saveddepartment, responseDto);

        return responseDto;
    }



}
