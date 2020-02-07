package com.followup.davidson.services;

import com.followup.davidson.model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    List<Project> findAll();

    Optional<Project> findById(Long id);

    Project create(Project project, Long clientId);

    Project update (Long id, Project project,Long clientId);

    void deleteProject(Long id);
}
