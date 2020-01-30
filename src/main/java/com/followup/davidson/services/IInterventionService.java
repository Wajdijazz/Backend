package com.followup.davidson.services;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IInterventionService {


    Optional<Intervention> findById(Long id);
    public List<Intervention> findAll();
    void saveInterventions(Date firstDate , Date secondDate , Person person , Project project);
    void deleteIntervention(Long personId,Long projectId);
    void deleteInterventionHistorique(Long id);

    // void workedDay(Intervention intervention);
}
