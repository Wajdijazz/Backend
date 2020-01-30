package com.followup.davidson.services;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;

import java.util.Date;
import java.util.Optional;

public interface IInterventionService {

    Intervention create(Intervention intervention);

    Optional<Intervention> findById(Long id);

    void saveInterventions(Date firstDate , Date secondDate , Person person , Project project);
    void deleteIntervention(Long personId,Long projectId);
   // void workedDay(Intervention intervention);
}
