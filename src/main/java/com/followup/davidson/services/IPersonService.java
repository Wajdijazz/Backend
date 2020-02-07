package com.followup.davidson.services;

import com.followup.davidson.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    List<Person> findAll();

    Person create(Person person, Long managerId);

    Optional<Person> findById(Long id);

    Person update(Long id, Person person, Long managerId);

    void deletePerson(Long personId);
}
