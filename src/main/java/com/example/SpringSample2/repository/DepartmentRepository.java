package com.example.SpringSample2.repository;

import com.example.SpringSample2.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
