package com.example.SpringSample2.repository;

import com.example.SpringSample2.entity.Department;
import com.example.SpringSample2.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {

    //by methodname

    List<Employee> findByDepartment(Department department);
    //
    List<Employee> findByDepartment_Id(Long departmentId);

    //by Query annotation
    @Query("Select  e FROM Employee e where e.department.id=?1 ")
    List<Employee> getEmployeeListByDepartmentId(Long departmentId);

    //by native query
  @Query(value="Select * from employee e where e.department_id=?1", nativeQuery= true)
    List<Employee> getEmployeeListByNativeQuery(Long departmentId);

}
