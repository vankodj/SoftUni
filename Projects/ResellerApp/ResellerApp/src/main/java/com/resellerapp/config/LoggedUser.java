package com.resellerapp.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private String username;
    private boolean isLoggedIn;

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public LoggedUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }
}
