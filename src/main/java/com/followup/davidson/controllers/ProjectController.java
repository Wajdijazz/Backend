package com.followup.davidson.controllers;
import com.followup.davidson.Routes;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.PROJECT  )

public class ProjectController {

    private IProjectService projectService;

    private ClientRepository clientRepository;

    private ProjectRepository projectRepository;

    public ProjectController(IProjectService projectService ,ClientRepository clientRepository , ProjectRepository projectRepository) {
        this.projectService=projectService;
        this.clientRepository=clientRepository;
        this.projectRepository=projectRepository;
    }

    @GetMapping( value = "/", produces = { "application/json" })
    public List<Project> getAllProject() {
        return projectService.findAll();
    }


    @PostMapping("/client/{clientId}/project")
    public Project createProject(@Valid @RequestBody Project project, @PathVariable(value = "clientId") Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            project.setClient(client);
            return projectService.create(project);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + clientId + " not found"));

    }

    @GetMapping("/{id}")
    public Project findProjectById(@PathVariable(value = "id") Long projectId) {
        return projectService.findById(projectId);

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
