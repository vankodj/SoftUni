package com.resellerapp.controller;

import com.resellerapp.model.binding.UserLoginBindingModel;
import com.resellerapp.model.binding.UserRegisterBindingModel;
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
    public String login(UserLoginBindingModel userLoginBindingModel) {
       boolean isLogged = this.userService.login(userLoginBindingModel);
        String view = isLogged ? "redirect:/home" : "login";
        return view;

    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(UserRegisterBindingModel userRegisterBindingModel){
        boolean isRegister = userService.register(userRegisterBindingModel);
       String view = isRegister ? "redirect:/login" : "register";
        return view;
    }
}
