package com.followup.davidson.services.implementation;

import com.followup.davidson.model.*;
import com.followup.davidson.repositories.TJRepository;
import com.followup.davidson.services.IPersonService;
import com.followup.davidson.services.IProjectService;
import com.followup.davidson.services.ITJService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class TJServiceImpl implements ITJService {
    private TJRepository tjRepository;
    private IProjectService projectService;
    private IPersonService personService;

    public TJServiceImpl(TJRepository tjRepository, IProjectService projectService, IPersonService personService) {
        this.tjRepository = tjRepository;
        this.projectService = projectService;
        this.personService = personService;
    }

    /**
     * Cette methode permet de lister tous les TJ de chaque personne et pour chaque projet
     *
     * @return une liste des {@link Client}
     */
    @Override
    public List<TJ> findAll() {
        return tjRepository.findAll();
    }

    /**
     * Cette methode permet de créer et sauvgarder un nouveau taus de jour
     *
     * @param tj
     * @param projectId
     * @param personId
     * @return le TJ crée
     */
    @Override
    public TJ create(TJ tj, Long projectId, Long personId) {
        Optional<Project> project = projectService.findById(projectId);
        Optional<Person> person = personService.findById(personId);
        tj.setProject(project.get());
        tj.setPerson(person.get());
        return tjRepository.save(tj);
    }

    /**
     * Cette methode permet de modifier un taux de jour pour une personne et sur un projet par son id
     *
     * @param id
     * @param projetId
     * @param personId
     */
    @Override
    public TJ update(Long id, TJ tj, Long projetId, Long personId) {
        Optional<TJ> tjUp = tjRepository.findById(id);
        Optional<Project> project = projectService.findById(projetId);
        Optional<Person> person = personService.findById(personId);
        tjUp.get().setTarif(tj.getTarif());
        tjUp.get().setProject(project.get());
        tjUp.get().setPerson(person.get());
        return tjRepository.save(tjUp.get());
    }

    /**
     * Cette methode permet de retourner un taux de jour par id
     *
     * @param id
     * @return un TJ
     */
    @Override
    public Optional<TJ> findById(Long id) {
        return tjRepository.findById(id);
    }

    /**
     * Cette methode permet de supprimer un tj par id
     *
     * @param id
     */
    @Override
    public void deleteTj(Long id) {
        tjRepository.deleteById(id);
    }

    @Override
    public long TjByProjectAndPerson(long projectId,long personId) {
        return tjRepository.TjByProjectAndPerson(projectId,personId);
    }


}
