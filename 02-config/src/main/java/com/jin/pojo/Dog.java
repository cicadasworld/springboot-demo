package com.jin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Dog {
    @Value("wangwang")
    private String name;
    @Value("3")
    private Integer age;
}
