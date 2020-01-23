package com.followup.davidson.controllers;



import com.followup.davidson.Routes;
import com.followup.davidson.model.Project;
import com.followup.davidson.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.PROJECT)
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @GetMapping("/")
    public List<Project> getAllProject() {
        return projectService.findAll();
    }


    @PostMapping("/")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.create(project);
    }

    @GetMapping("/{id}")
    public Project findProjectById(@PathVariable(value = "id") Long projectId)
    {
        return projectService.findById(projectId);

    }
    @DeleteMapping("/{id}")
    public void deletePeroject(@PathVariable(value = "id") Long projectId)
    {
        projectService.deleteProject(projectId);
    }

}
