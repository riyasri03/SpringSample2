package com.example.SpringSample2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
public class Department {
    @Id

    @GenericGenerator(name = "department_id_seq", strategy = "increment")
    @GeneratedValue(generator = "department_id_seq", strategy = GenerationType.AUTO)

    private Long id;
    private String name;

}
