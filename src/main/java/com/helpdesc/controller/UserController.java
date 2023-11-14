package com.helpdesc.controller;

import com.helpdesc.model.user.Client;
import org.springframework.ui.Model;
import com.helpdesc.model.user.User;
import com.helpdesc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("client") Client client){
        return "register";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("client") Client client){
        userService.register(client);

        return "redirect:/home";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model){
        model.addAttribute("users", userService.getUserList());
        return "users";
    }
}
