package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Intervention;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IInterventionService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.INTERVENTION)
public class InterventionController {


    private IInterventionService interventionService;

    private ProjectRepository projectRepository;
    private PersonRepository personRepository;


    public InterventionController(IInterventionService interventionService ,ProjectRepository projectRepository, PersonRepository personRepository ) {
        this.projectRepository=projectRepository;
        this.personRepository=personRepository;
        this.interventionService=interventionService;
    }

    @GetMapping("/")
    public List<Intervention> getAllIntervention() {
        return interventionService.findAll();
    }



    @PostMapping("/project/{projectId}/person/{personId}")
    public Intervention createIntervention(@Valid @RequestBody Intervention intervention, @PathVariable(value = "projectId") Long projectId , @PathVariable(value = "personId") Long personId) {
        return projectRepository.findById(projectId).map(project -> {
            intervention.setProject(project);
            personRepository.findById(personId).map(person -> {
                        intervention.setPerson(person);
                        return interventionService.create(intervention);
                    }
            );
            return intervention; }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + " not found"));

    }

    @GetMapping("/{id}")
    public Optional<Intervention> findInterventionById(@PathVariable(value = "id") Long interventionId)
    {
        return interventionService.findById(interventionId);

    }
    @DeleteMapping("/{id}")
    public void deleteIntervention(@PathVariable(value = "id") Long interventionId)
    {
        interventionService.deleteIntervention(interventionId);
    }
}
