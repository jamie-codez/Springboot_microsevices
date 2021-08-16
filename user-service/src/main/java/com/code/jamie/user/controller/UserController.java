package com.code.jamie.user.controller;

import com.code.jamie.user.entity.User;
import com.code.jamie.user.service.UserService;
import com.code.jamie.user.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method in "+getClass().getName());
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
        log.info("Inside getUserWithDepartment method in "+getClass().getName());
        return userService.getUserWithDepartment(id);
    }
}
