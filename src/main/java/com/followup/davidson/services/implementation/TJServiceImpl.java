package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.model.TJ;
import com.followup.davidson.repositories.TJRepository;
import com.followup.davidson.services.IPersonService;
import com.followup.davidson.services.IProjectService;
import com.followup.davidson.services.ITJService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TJServiceImpl  implements ITJService {
    private TJRepository tjRepository;
    private IProjectService projectService;
    private IPersonService personService;

    public TJServiceImpl(TJRepository tjRepository,IProjectService projectService,IPersonService personService) {
        this.tjRepository=tjRepository;
        this.projectService=projectService;
        this.personService=personService;
    }

    @Override
    public List<TJ> findAll() {
        return tjRepository.findAll();

    }

    @Override
    public TJ create(TJ tj, Long projectId, Long personId) {
        Optional<Project> project= projectService.findById(projectId);
        Optional<Person> person= personService.findById(personId);
        tj.setProject(project.get());
        tj.setPerson(person.get());
        return  tjRepository.save(tj);
    }


    @Override
    public Optional<TJ> findById(Long id) {
        return tjRepository.findById(id);
    }

    @Override
    public void deleteTj(Long id) {
        tjRepository.deleteById(id);
    }
}
