package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Client;
import com.followup.davidson.model.Manager;
import com.followup.davidson.model.Person;
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


    public ProjectServiceImpl(ProjectRepository projectRepository, IClientService clientService) {
        this.projectRepository = projectRepository;
        this.clientService = clientService;
    }

    /**
     * Cette methode permet de lister tous les projets de davidsons
     *
     * @return une liste des {@link Project}
     */
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    /**
     * Cette methode permet de retourner un projet par id
     *
     * @param id
     * @return un client
     */
    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Cette methode permet de créer et sauvgarder un nouveau projet
     *
     * @param project
     * @return projet crée
     */
    @Override
    public Project create(Project project, Long clientId) {
        Optional<Client> client = clientService.findById(clientId);
        project.setClient(client.get());
        return projectRepository.save(project);
    }

    /**
     * Cette methode permet de modifier  les informations  d'un projet par son id
     *
     * @param id
     * @param clientId
     */
    @Override
    public Project update(Long id, Project project, Long clientId) {
        Optional<Project> projectUp = projectRepository.findById(id);
        Optional<Client> client = clientService.findById(clientId);
        projectUp.get().setProjectName(project.getProjectName());
        projectUp.get().setClient(client.get());
        return projectRepository.save(projectUp.get());
    }

    /**
     * Cette methode permet de supprimer un projet par son id
     *
     * @param id
     */
    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteInterventionByIdProject(id);
        projectRepository.deleteById(id);
    }
}
