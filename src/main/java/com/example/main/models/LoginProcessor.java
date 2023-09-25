package com.example.main.models;

import com.example.main.aspects.ToLog;
import com.example.main.services.LoggedUserManagementService;
import com.example.main.services.LoginCountService;
import com.example.main.services.SuccessLoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private final SuccessLoginCountService successLoginCountService;
    private String username;
    private String password;
    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService, SuccessLoginCountService successLoginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
        this.successLoginCountService = successLoginCountService;
    }

    @ToLog
    public boolean login(){
        loginCountService.increment();
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;
        if (("natalie".equals(username) && "password".equals(password)) || ("adilet".equals(username) && "password".equals(password))) {
            loginResult = true;
            successLoginCountService.increment();
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
