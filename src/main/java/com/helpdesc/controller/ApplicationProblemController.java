package com.helpdesc.controller;

import com.helpdesc.model.ApplicationProblem;
import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Master;
import com.helpdesc.service.ApplicationProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationProblemController {

    @Autowired
    private final ApplicationProblemService applicationProblemService;

    public ApplicationProblemController(ApplicationProblemService applicationProblemService) {
        this.applicationProblemService = applicationProblemService;
    }

    @GetMapping("/problems")
    public String getProblems(Model model){
        model.addAttribute("problems", applicationProblemService.getListProblems());
        return "problems";
    }

    @GetMapping("/addProblem")
    public String createProblems(@ModelAttribute("problem") ApplicationProblem problem){
        return "addProblem";
    }

    @PostMapping("/addProblem")
    public String addProblems(@ModelAttribute("problem") ApplicationProblem problem){
        Client client = new Client("NameClient", "SurnameClient", "PatronymicClient", "UsernameClient", "1234");
        Master master = new Master("NameMaster", "SurnameMaster", "PatronymicMaster", "UsernameMaster", "1234");
        applicationProblemService.createProblems(problem, client, master);
        return "redirect:/problems";
    }

}
