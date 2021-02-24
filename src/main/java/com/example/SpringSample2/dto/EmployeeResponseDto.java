package com.example.SpringSample2.dto;

import com.example.SpringSample2.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponseDto {

    private long id;
    private String name;
    private DepartmentResponseDto department;

    public void setDepartmentFromEntity(Department departmentEntity){
        DepartmentResponseDto departmentResponseDto= new DepartmentResponseDto();
        departmentResponseDto.setId(departmentEntity.getId());
        departmentResponseDto.setName(departmentEntity.getName());
        this.department= departmentResponseDto;

    }
}
