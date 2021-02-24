package com.example.SpringSample2.repository;

import com.example.SpringSample2.entity.Department;
import com.example.SpringSample2.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {

    //by methodname

    List<Employee> findByDepartment(Department department);
    //

}
