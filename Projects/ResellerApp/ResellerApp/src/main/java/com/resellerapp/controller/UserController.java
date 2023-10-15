package com.resellerapp.controller;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO loginDTO){
        return "home";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
