package com.example.SpringSample2.service;


import com.example.SpringSample2.dto.EmployeeRequestDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);


    EmployeeResponseDto getEmployeeById(Long id);
    EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto deleteEmployeeById(Long id);
}
