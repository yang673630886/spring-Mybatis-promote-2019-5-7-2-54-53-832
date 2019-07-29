package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    @ResponseBody
    public List<User> findInPage(@RequestParam(defaultValue = "1") int pageNum,
                                 @RequestParam(defaultValue = "20") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findAllPage();
    }

//    @GetMapping("/user")
//    public List<User> findAll() {
//        return userMapper.findAllPage();
//
//    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {
        return userMapper.findByID(userId);
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userMapper.addUser(user);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable int userId) {
        userMapper.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable int userId) {
        userMapper.deleteUser(userId);
    }
}
