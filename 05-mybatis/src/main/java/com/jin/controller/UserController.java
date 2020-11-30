package com.jin.controller;

import com.jin.mapper.UserMapper;
import com.jin.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(5, "田七", "555555"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(5, "田七", "666666"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(5);
        return "ok";
    }
}
