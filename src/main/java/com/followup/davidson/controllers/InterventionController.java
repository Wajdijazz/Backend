package com.followup.davidson.controllers;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.followup.davidson.Routes;
import com.followup.davidson.model.Intervention;

import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IInterventionService;

import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.InterventionRepository;

import lombok.Data;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.INTERVENTION)
public class InterventionController {


    private IInterventionService interventionService;
    private ProjectRepository projectRepository;
    private PersonRepository personRepository;
    private InterventionRepository interventionRepository;


    public InterventionController(IInterventionService interventionService, ProjectRepository projectRepository,
                                  PersonRepository personRepository, InterventionRepository interventionRepository) {
        this.projectRepository = projectRepository;
        this.personRepository = personRepository;
        this.interventionRepository = interventionRepository;
        this.interventionService = interventionService;
    }

    @GetMapping("/")
    public List<Intervention> getAllIntervention() {
        return interventionService.findAll();
    }

    @PostMapping("/project/{projectId}/person/{personId}")
    public Object createIntervention(@Valid @RequestBody InterventionForm interventionForm,
                                     @PathVariable(value = "projectId") Long projectId
            , @PathVariable(value = "personId") Long personId) {
        System.out.println(interventionForm);
        return projectRepository.findById(projectId).map(project -> {
            interventionForm.setProject(project);
            personRepository.findById(personId).map(person -> {
                        interventionForm.setPerson(person);
                        interventionService.saveInterventions(interventionForm.getStartDate(),
                                interventionForm.getEndDate(), interventionForm.getPerson(),
                                interventionForm.getProject());
                        return null;
                    }
            );
            ;
            ;
            return null;
        }).orElseThrow(() -> new ResourceNotFoundException("PersonId " + personId + " not found" +
                "ProjectId" + projectId + "nt found"));

    }

    @GetMapping("/{id}")
    public Optional<Intervention> findInterventionById(@PathVariable(value = "id") Long interventionId) {
        return interventionService.findById(interventionId);
    }

    @GetMapping("/project/{projectId}/person/{personId}")
    List<Intervention> getInterventionByPersonAndProject(@PathVariable(value = "projectId") Long projectId,
                                                         @PathVariable(value = "personId") Long personId) {
        return interventionService.findByPersonAndProject(projectId, personId);
    }

    @GetMapping("/worked/project/{projectId}/person/{personId}")
    long getworkedByPersonAndProject(@PathVariable(value = "projectId") Long projectId,
                                     @PathVariable(value = "personId") Long personId) {
        return interventionService.workedDayByPersonAndProject(projectId, personId);
    }

    @DeleteMapping("/person/{personId}/project/{projectId}")
    public void deleteInterventionByIdPersonAndProject(@PathVariable(value = "personId") Long personId,
                                   @PathVariable(value = "projectId") Long projectId) {
        interventionService.deleteIntervention(personId, projectId);
    }

    @DeleteMapping("/{id}")
    public void deleteInterventionById(@PathVariable(value = "id") Long id) {
        interventionService.deleteInterventionHistorique(id);
    }

    @Data
    static class InterventionForm {
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date startDate;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date endDate;
        private Person person;
        private Project project;
    }
}
