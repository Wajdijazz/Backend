package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Manager;
import com.followup.davidson.model.Person;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.services.IManagerService;
import com.followup.davidson.services.IPersonService;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonServiceImpl implements IPersonService {

    private PersonRepository personRepository;
    private IManagerService managerService;

    public PersonServiceImpl(PersonRepository personRepository,IManagerService managerService) {
        this.personRepository=personRepository;
        this.managerService=managerService;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person person,Long managerId) {
        Optional<Manager> manager= managerService.findById(managerId);
        person.setManager(manager.get());
        return personRepository.save(person);
    }


    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteInterventionByIdPerson(id);
        personRepository.deleteById(id);

    }
}
