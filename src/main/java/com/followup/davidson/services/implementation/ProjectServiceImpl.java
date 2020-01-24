package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Client;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Project> findAll() {
        return  projectRepository.findAll();    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(new Project());
    }

    @Override

    public Project create(Project project ){

    public Project create(Project project){
        

        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

    }
}
