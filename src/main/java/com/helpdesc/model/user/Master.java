package com.helpdesc.model.user;

import com.helpdesc.model.ApplicationProblem;

import java.util.List;

public class Master extends User{

    private String position;
    private List<ApplicationProblem> applicationProblems;

    public Master(String name, String surname, String patronymic, String username, String password) {
        super(name, surname, patronymic, username, password);
    }

    public Master() {
    }
}
