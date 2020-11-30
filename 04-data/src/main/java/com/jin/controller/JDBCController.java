package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/add-user")
    public void addUser() {
        String sql = "insert into user (id, name, pwd) values (5, '田七', '123456')";
        jdbcTemplate.update(sql);
    }

    @GetMapping("/update-user/{id}")
    public void updateUser(@PathVariable("id") int id) {
        String sql = "update user set name = ?, pwd = ? where id = " + id;
        Object[] args = new Object[] {"田七", "111111"};
        jdbcTemplate.update(sql, args);
    }

    @GetMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
