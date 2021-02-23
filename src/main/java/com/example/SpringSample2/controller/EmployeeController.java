package com.example.SpringSample2.controller;

import com.example.SpringSample2.dto.EmployeeRequestDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;
import com.example.SpringSample2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //POST - /employee
    @PostMapping
    public EmployeeResponseDto createEmployee
    (@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.createEmployee(employeeRequestDto);
    }

    //GET - /employee/{id}
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    //PUT - /employee/{id}
    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.updateEmployeeById(id, employeeRequestDto);
    }

    //DELETE - /employee/{id}
    @DeleteMapping("/{id}")
    public EmployeeResponseDto deleteEmployee(@PathVariable("id") Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
