package com.followup.davidson.services;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IInterventionService {

    Intervention create(Intervention intervention);
    Intervention findById(Long id);
    void saveInterventions(Date firstDate , Date secondDate , Person person , Project project);
    void deleteIntervention(Long id);
   // void workedDay(Intervention intervention);
}
