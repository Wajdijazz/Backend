package com.followup.davidson.services;

import com.followup.davidson.model.Client;
import com.followup.davidson.model.Project;

import java.util.List;

public interface IProjectService {

    List<Project> findAll();
    Project findById(Long id);
    Project create(Project project );
    void deleteProject(Long id);
}
