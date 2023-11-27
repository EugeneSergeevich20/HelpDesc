package com.helpdesc.controller;

import com.helpdesc.model.user.Client;
import com.helpdesc.service.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserRegistrationService userRegistrationService;

    public AuthController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("client") Client client){
        return "register";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("client") Client client){
        userRegistrationService.register(client);

        return "redirect:/home";
    }
}
