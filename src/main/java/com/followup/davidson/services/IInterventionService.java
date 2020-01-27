package com.followup.davidson.services;

import com.followup.davidson.model.Intervention;

import java.util.List;

public interface IInterventionService {

    List<Intervention> findAll();
    Intervention create(Intervention intervention);
    Intervention findById(Long id);
    void deleteIntervention(Long id);
    void workedDay(Intervention intervention);
}
