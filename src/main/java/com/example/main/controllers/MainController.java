package com.example.main.controllers;

import com.example.main.services.ActiveUsersService;
import com.example.main.services.LoggedUserManagementService;
import com.example.main.services.LoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final ActiveUsersService activeUsersService;
    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService, ActiveUsersService activeUsersService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.activeUsersService = activeUsersService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String Logout, Model model){
        if(Logout != null){
            loggedUserManagementService.setUsername(null);
            activeUsersService.decrement();
        }

        String username = loggedUserManagementService.getUsername();
        if(username == null){
            return "redirect:/";
        }
        model.addAttribute("username",username);
        return "main.html";
    }
}
