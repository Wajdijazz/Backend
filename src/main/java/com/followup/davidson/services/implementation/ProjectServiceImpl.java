package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Client;
import com.followup.davidson.model.Manager;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.IClientService;
import com.followup.davidson.services.IProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProjectServiceImpl implements IProjectService {


    private ProjectRepository projectRepository;
    private IClientService clientService;



    public ProjectServiceImpl(ProjectRepository projectRepository,IClientService clientService) {
        this.projectRepository=projectRepository;
        this.clientService=clientService;
    }

    @Override
    public List<Project> findAll() {
        return  projectRepository.findAll();    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project create(Project project, Long clientId) {
        Optional<Client> client= clientService.findById(clientId);
        project.setClient(client.get());
        return projectRepository.save(project);
    }


    public Project create(Project project){
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);

    }
}
