package com.example.SpringSample2.repository;

import com.example.SpringSample2.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {

}
