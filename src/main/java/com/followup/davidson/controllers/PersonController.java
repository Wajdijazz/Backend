package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Person;
import com.followup.davidson.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Routes.PERSON)
@CrossOrigin(origins = "*")
public class PersonController {
    @Autowired
    private IPersonService personService;




    @GetMapping("/")
    public List<Person> getAllPerson() {
        return personService.findAll();
    }


    @PostMapping("/")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable(value = "id") Long personId)
    {
        return personService.findById(personId);

    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable(value = "id") Long personId)
    {
         personService.deletePerson(personId);
    }



}
