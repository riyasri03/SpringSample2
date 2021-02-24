package com.example.SpringSample2.service.impl;

import com.example.SpringSample2.dto.EmployeeRequestDto;
import com.example.SpringSample2.dto.EmployeeResponseDto;
import com.example.SpringSample2.entity.Department;
import com.example.SpringSample2.entity.Employee;
import com.example.SpringSample2.repository.DepartmentRepository;
import com.example.SpringSample2.repository.EmployeeRespository;
import com.example.SpringSample2.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();

        //copy fields from dto to employee
        BeanUtils.copyProperties(employeeRequestDto, employee);

        //fetch department from db
        Optional<Department> departmentOptional =
                departmentRepository.findById(employeeRequestDto.getDepartment().getId());
        if (departmentOptional.isPresent()){
            employee.setDepartment(departmentOptional.get());
        }else {
            Department department = new Department();
            department.setName(employeeRequestDto.getDepartment().getName());
            employee.setDepartment(department);
        }

        //save employee to db
        Employee savedEmployee = employeeRespository.save(employee);

        // copy from employee to response dto
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedEmployee, responseDto);

        responseDto.setDepartmentFromEntity(employee.getDepartment());

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

            Optional<Department> departmentOptional= departmentRepository.findById(employeeRequestDto.getDepartment().getId());
            if (departmentOptional.isPresent()){
                employeeFromDb.setDepartment(departmentOptional.get());
            }
           // employeeFromDb.setDepartment(employeeRequestDto.getDepartment());

           Employee savedEmployee= employeeRespository.save(employeeFromDb);

           EmployeeResponseDto responseDto= new EmployeeResponseDto();
            BeanUtils.copyProperties(employeeOptional.get(), responseDto);
           responseDto.setDepartmentFromEntity(savedEmployee.getDepartment());

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

    @Override
    public List<EmployeeResponseDto> getEmployeeListByDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRespository.findByDepartment(department);
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();
        for (Employee employee : employeeList){
            EmployeeResponseDto responseDto = new EmployeeResponseDto();
            BeanUtils.copyProperties(employee, responseDto);
            responseDto.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDtoList.add(responseDto);
        }
        return employeeResponseDtoList;
    }
}
