package com.example.SpringSample2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
    @Id


    @GenericGenerator(name = "employee_id_seq", strategy = "increment")
    @GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO)



    private long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

}
