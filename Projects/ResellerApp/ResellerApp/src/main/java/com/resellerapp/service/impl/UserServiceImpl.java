package com.resellerapp.service.impl;

import com.resellerapp.config.LoggedUser;
import com.resellerapp.model.binding.UserLoginBindingModel;
import com.resellerapp.model.binding.UserRegisterBindingModel;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (userRegisterBindingModel==null){
            return false;
        }
        String username = userRegisterBindingModel.getUsername();
        if(this.userRepository.findByUsername(username).isPresent()){
            return false;
        };

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setEmail(userRegisterBindingModel.getEmail());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
  User user = findUserByUsername(userLoginBindingModel.getUsername());
  if (user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())){
      loggedUser.setUsername(user.getUsername());
      loggedUser.setLoggedIn(true);
      return true;
  }
        return false;
    }

    private User findUserByUsername(String username){
        return userRepository.findByUsername(username).get();
    }
}
