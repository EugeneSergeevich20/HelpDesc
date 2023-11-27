package com.helpdesc.controller;

import com.helpdesc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model){
        model.addAttribute("users", adminService.findAllUsers());
        return "users";
    }

}
