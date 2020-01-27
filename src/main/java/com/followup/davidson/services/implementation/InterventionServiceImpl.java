package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.repositories.InterventionRepository;
import com.followup.davidson.services.IInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class InterventionServiceImpl implements IInterventionService {

    InterventionRepository interventionRepository;

    public InterventionServiceImpl(  InterventionRepository interventionRepository) {
        this.interventionRepository=interventionRepository;
    }

    @Override
    public List<Intervention> findAll() {
        return interventionRepository.findAll();    }

    @Override
    public Intervention create(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @Override
    public Intervention findById(Long id) {
        return interventionRepository.findById(id).orElse(new Intervention());
    }

    @Override
    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);

    }
}
