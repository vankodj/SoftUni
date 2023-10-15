package com.resellerapp.service;

import com.resellerapp.model.binding.UserLoginBindingModel;
import com.resellerapp.model.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Service;


public interface UserService {

    public void register(UserRegisterBindingModel userRegisterBindingModel);

    void login(UserLoginBindingModel userLoginBindingModel);
}
