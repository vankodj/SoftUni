package com.resellerapp.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserRegisterBindingModel {

    @Length(min = 3,max = 20)
    private String username;

    @Email
    private String email;

    @Length(min = 3,max = 20)
    private String password;

    private String confirmPassword;

}
