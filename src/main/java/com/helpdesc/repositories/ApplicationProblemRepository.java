package com.helpdesc.repositories;

import com.helpdesc.model.ApplicationProblem;
import com.helpdesc.model.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationProblemRepository extends JpaRepository<ApplicationProblem, Long> {

    List<ApplicationProblem> findByClient(Client client);

}
