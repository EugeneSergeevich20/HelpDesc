package com.helpdesc.model;

import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Master;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_problem")
public class ApplicationProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProblem;
    private String descriptionProblem;
    @CreationTimestamp
    private LocalDateTime createProblem;
    private LocalDateTime stopProblem;
    @Enumerated(EnumType.STRING)
    private Status statusProblem;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master master;

    public String getNameProblem() {
        return nameProblem;
    }

    public void setNameProblem(String nameProblem) {
        this.nameProblem = nameProblem;
    }

    public String getDescriptionProblem() {
        return descriptionProblem;
    }

    public void setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
    }

    public LocalDateTime getCreateProblem() {
        return createProblem;
    }

    public void setCreateProblem(LocalDateTime createProblem) {
        this.createProblem = createProblem;
    }

    public LocalDateTime getStopProblem() {
        return stopProblem;
    }

    public void setStopProblem(LocalDateTime stopProblem) {
        this.stopProblem = stopProblem;
    }

    public Status getStatusProblem() {
        return statusProblem;
    }

    public void setStatusProblem(Status statusProblem) {
        this.statusProblem = statusProblem;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
