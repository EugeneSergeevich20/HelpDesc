package com.helpdesc.model.user;

import com.helpdesc.model.ApplicationProblem;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client extends User{

    @OneToMany(mappedBy = "client")
    private List<ApplicationProblem> applicationProblems;

    public Client(String name, String surname, String patronymic, String username, String password) {
        super(name, surname, patronymic, username, password);
    }

    public Client() {
    }

    public List<ApplicationProblem> getApplicationProblems() {
        return applicationProblems;
    }

    public void setApplicationProblems(List<ApplicationProblem> applicationProblems) {
        this.applicationProblems = applicationProblems;
    }
}
