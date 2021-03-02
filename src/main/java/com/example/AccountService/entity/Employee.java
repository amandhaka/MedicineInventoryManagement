package com.example.AccountService.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "Employee")
public class Employee {

    @Id
    @GenericGenerator(name = "employee_id_seq" , strategy = "increment")
    @GeneratedValue(generator="employee_id_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
}
