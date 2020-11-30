package com.jin.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private Integer age;
    private Boolean happy;
    private Date dob;
    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;
}
