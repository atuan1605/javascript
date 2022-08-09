package com.example.springlogin.controller;

import com.example.springlogin.dto.UserDto;
import com.example.springlogin.request.LoginRequest;
import com.example.springlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping ("/login")
    public UserDto loginUser(@RequestBody LoginRequest request){
        return userService.loginUser(request);
    }

}
