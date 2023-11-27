package com.helpdesc.model.user;

import com.helpdesc.model.ApplicationProblem;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_master")
public class Master extends User{
    @Enumerated(EnumType.STRING)
    private PositionMaster position;
    @OneToMany(mappedBy = "master")
    private List<ApplicationProblem> applicationProblems;

    public Master(String name, String surname, String patronymic, String username, String password) {
        super(name, surname, patronymic, username, password);
    }

    public Master() {
    }
}
