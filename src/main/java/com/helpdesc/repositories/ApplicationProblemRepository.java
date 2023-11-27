package com.helpdesc.repositories;

import com.helpdesc.model.ApplicationProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationProblemRepository extends JpaRepository<ApplicationProblem, Long> {
}
