package com.helpdesc.service;

import com.helpdesc.model.ApplicationProblem;
import com.helpdesc.model.Status;
import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Master;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationProblemService {

    List<ApplicationProblem> problemServices;

    public ApplicationProblemService() {
        problemServices = new ArrayList<>();
    }

    public List<ApplicationProblem> getListProblems(){
        return problemServices;
    }

    public void createProblems(ApplicationProblem problem, Client client, Master master){
        problem.setCreateProblem(LocalDateTime.now());
        problem.setStatusProblem(Status.STATUS_NEW);
        problem.setClient(client);
        problem.setMaster(master);
        problemServices.add(problem);
    }

}
