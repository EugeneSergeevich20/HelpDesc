package com.helpdesc.service;

import com.helpdesc.model.ApplicationProblem;
import com.helpdesc.model.Status;
import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Master;
import com.helpdesc.repositories.ApplicationProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationProblemService {

    private final ApplicationProblemRepository applicationProblemRepository;

    public ApplicationProblemService(ApplicationProblemRepository applicationProblemRepository) {
        this.applicationProblemRepository = applicationProblemRepository;
    }


    public List<ApplicationProblem> findAllProblems(){
        return applicationProblemRepository.findAll();
    }

    public List<ApplicationProblem> findByClient(Client client){
        return applicationProblemRepository.findByClient(client);
    }

    public void createProblems(ApplicationProblem problem, Client client, Master master){
        problem.setStatusProblem(Status.STATUS_NEW);
        problem.setClient(client);
        problem.setMaster(master);
        applicationProblemRepository.save(problem);
    }

}
