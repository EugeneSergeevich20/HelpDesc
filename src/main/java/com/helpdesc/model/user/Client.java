package com.helpdesc.model.user;

import com.helpdesc.model.ApplicationProblem;

import java.util.List;

public class Client extends User{

    private String test;
    private List<ApplicationProblem> applicationProblems;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
