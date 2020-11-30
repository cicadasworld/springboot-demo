package com.jin.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender; // 0 female 1 male
    private Department department;
    private Date date;

    public Employee(Integer id, String employeeName, String email, Integer gender, Department department) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.date = new Date();
    }
}
