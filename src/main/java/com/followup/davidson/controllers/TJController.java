package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Project;
import com.followup.davidson.model.TJ;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IPersonService;
import com.followup.davidson.services.IProjectService;
import com.followup.davidson.services.ITJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Routes.TJ)
public class TJController {



    private ITJService tjService;
    private ProjectRepository projectRepository;
    private PersonRepository personRepository;

    public TJController(  ITJService tjService ,ProjectRepository projectRepository,PersonRepository personRepository) {
        this.tjService=tjService;
        this.projectRepository=projectRepository;
        this.personRepository=personRepository;
    }

    @GetMapping("/")
    public List<TJ> getTj() {
        return tjService.findAll();
    }




    @PostMapping("/project/{projectId}/person/{personId}")
    public TJ createTj(@Valid @RequestBody TJ tj, @PathVariable(value = "projectId") Long projectId , @PathVariable(value = "personId") Long personId) {
        return projectRepository.findById(projectId).map(project -> {
            tj.setProject(project);
             personRepository.findById(personId).map(person -> {
                tj.setPerson(person);
                         return tjService.create(tj);
            }
                );
       return tj; }).orElseThrow(() -> new ResourceNotFoundException("PostId " + personId + " not found"));

    }
    @GetMapping("/{id}")
    public TJ findTjById(@PathVariable(value = "id") Long tjId) {
        return tjService.findById(tjId);
    }

    @DeleteMapping("/{id}")
    public void deleteTj(@PathVariable(value = "id") Long tjId) {
        tjService.deleteTj(tjId);

    }
}
