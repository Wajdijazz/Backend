package com.followup.davidson.controllers;

import com.followup.davidson.Routes;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IProjectService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.PROJECT)

public class ProjectController {

    private IProjectService projectService;

    private ClientRepository clientRepository;

    private ProjectRepository projectRepository;

    public ProjectController(IProjectService projectService, ClientRepository clientRepository,
                             ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.clientRepository = clientRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping(value = "/", produces = {"application/json"})
    public List<Project> getAllProject() {
        return projectService.findAll();
    }


    @PostMapping("/client/{clientId}/project")
    public Project createProject(@Valid @RequestBody Project project, @PathVariable(value = "clientId") Long clientId) {
        return projectService.create(project, clientId);
    }

    @GetMapping("/{id}")
    public Optional<Project> findProjectById(@PathVariable(value = "id") Long projectId) {
        return projectService.findById(projectId);
    }

    @Transactional
    @PutMapping("/{id}/{clientId}")
    public Project updateController(@PathVariable(value = "id") Long id, @RequestBody Project project,
                                   @PathVariable(value = "clientId") Long clientId)
    {
        return projectService.update(id,project,clientId);
    }

    @DeleteMapping("/{id}")
    public void deletePeroject(@PathVariable(value = "id") Long projectId) {
        projectService.deleteProject(projectId);
    }

    @GetMapping("/active")
    long getActiveProjects() {
        return projectRepository.getActiveProjects();
    }

}
