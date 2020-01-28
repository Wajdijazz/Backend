package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProjectServiceImpl implements IProjectService {


    private ProjectRepository projectRepository;



    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository=projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return  projectRepository.findAll();    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override



    public Project create(Project project){
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

    }
}
