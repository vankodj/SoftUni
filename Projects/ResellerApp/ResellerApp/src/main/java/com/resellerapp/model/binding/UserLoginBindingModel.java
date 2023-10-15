package com.resellerapp.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    @Length(min = 3,max = 20)
    private String username;

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Length(min = 3,max = 20)
    private String password;
}
