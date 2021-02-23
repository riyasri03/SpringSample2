package com.example.SpringSample2.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.MongoId;
//import org.hibernate.annotations.GenericGenerator;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//@Entity
//@Document

@RedisHash
@Getter
@Setter
public class Employee {
   @Id
//
//
//    @GenericGenerator(name = "employee_id_seq", strategy = "increment")
//    @GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO)

// @MongoId



    private long id;
    private String name;
    private String department;

}
