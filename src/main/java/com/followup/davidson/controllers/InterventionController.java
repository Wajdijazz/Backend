package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Intervention;
import com.followup.davidson.services.IInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.INTERVENTION)
public class InterventionController {


    private IInterventionService interventionService;

    public InterventionController(IInterventionService interventionService ) {

        this.interventionService=interventionService;
    }

    @GetMapping("/")
    public List<Intervention> getAllIntervention() {
        return interventionService.findAll();
    }


    @PostMapping("/")
    public Intervention createIntervention(@Valid @RequestBody Intervention intervention) {

        return interventionService.create(intervention);
    }

    @GetMapping("/{id}")
    public Intervention findInterventionById(@PathVariable(value = "id") Long interventionId)
    {
        return interventionService.findById(interventionId);

    }
    @DeleteMapping("/{id}")
    public void deleteIntervention(@PathVariable(value = "id") Long interventionId)
    {
        interventionService.deleteIntervention(interventionId);
    }
}
