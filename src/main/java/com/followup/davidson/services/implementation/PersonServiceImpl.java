package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Person;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);


    }
}
