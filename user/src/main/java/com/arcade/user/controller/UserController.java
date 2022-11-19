package com.arcade.user.controller;

import com.arcade.user.entity.UserModel;
import com.arcade.user.service.UserService;
import com.arcade.user.valueobjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserModel saveUser(@RequestBody UserModel user) {
        log.info("Controller : user save method");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable Long id) {
        log.info("Controller : get user with department");
        return userService.getUserWithDepartment(id);
    }
}
