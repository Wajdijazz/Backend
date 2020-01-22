package com.followup.davidson.services;

import com.followup.davidson.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();
    Person create(Person person);
    Person findById(Long id);
    void deletePerson(Long id);
}
