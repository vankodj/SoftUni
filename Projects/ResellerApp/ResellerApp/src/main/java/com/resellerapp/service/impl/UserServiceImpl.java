package com.resellerapp.service.impl;

import com.resellerapp.model.binding.UserRegisterBindingModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

    }
}
