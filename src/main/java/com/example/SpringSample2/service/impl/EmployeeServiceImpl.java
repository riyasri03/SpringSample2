package com.example.SpringSample2.service.impl;

import com.example.SpringSample2.dto.EmployeeRequestDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;
import com.example.SpringSample2.entity.Employee;
import com.example.SpringSample2.repository.EmployeeRespository;
import com.example.SpringSample2.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;
    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto){
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeRequestDto , employee);
        Employee savedEmployee= employeeRespository.save(employee);

        EmployeeResponseDto responseDto= new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee, responseDto);

        return responseDto;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id){
        Optional<Employee> employeeOptional= employeeRespository.findById(id);
        if(employeeOptional.isPresent()){
            EmployeeResponseDto responseDto= new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), responseDto);

            return responseDto;
        }
          return null;
    }

    @Override
    public  EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto){
        Optional<Employee> employeeOptional= employeeRespository.findById(id);
        if(employeeOptional.isPresent()){
           Employee employeeFromDb= employeeOptional.get();
           employeeFromDb.setName(employeeRequestDto.getName());
            employeeFromDb.setDepartment(employeeRequestDto.getDepartment());

           Employee savedEmployee= employeeRespository.save(employeeFromDb);

           EmployeeResponseDto responseDto= new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), responseDto);

            return responseDto;
        }
        return null;
    }

    @Override
    public EmployeeResponseDto deleteEmployeeById(Long id){
        Optional<Employee> employeeOptional= employeeRespository.findById(id);
        if (employeeOptional.isPresent()){

            employeeRespository.deleteById(id);
            EmployeeResponseDto responseDto= new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), responseDto);

            return responseDto;


        }
        return null;
    }
}
