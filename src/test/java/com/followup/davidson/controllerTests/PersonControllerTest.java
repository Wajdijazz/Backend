package com.followup.davidson.controllerTests;


import com.followup.davidson.controllers.PersonController;
import com.followup.davidson.model.Manager;
import com.followup.davidson.model.Person;
import com.followup.davidson.services.IPersonService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonControllerTest {

    private static Person p1;
    private static Person p2;
    private static Manager m1;




    @Mock
    private IPersonService personService;
    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
    p1=new Person(1L,"Wajdi","Jaziri",null);
    p2=new Person(1L,"Davidson","Consulting",null);
        m1=new Manager(1L,"Wajdi","Jaziri");





    }

    @Test
    void create() {

        Person p= personController.createPerson(p1,1L);
        Mockito.verify(personService, Mockito.times(1)).create(p1,1L);

    }



    @Test
    void findAll_whenNoRecord() {

        Mockito.when(personService.findAll()).thenReturn(Arrays.asList());
        assertThat(personController.getAllPerson().size(), is(0));
        Mockito.verify(personService, Mockito.times(1)).findAll();
    }

    @Test
    void findAll_whenRecord() {

        Mockito.when(personService.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertThat(personController.getAllPerson().size(), is(2));
        Mockito.verify(personService, Mockito.times(1)).findAll();
    }
    @Test
    void findById_WhenMatch() {

        Mockito.when(personService.findById(1L)).thenReturn(Optional.of(p1));
        Optional<Person> p = personController.findPersonById(1L);
        assertThat(p.get(), is(p1) );
    }


    @Test
    void deleteById_WhenFound() {

        lenient().when(personService.findById(1L)).thenReturn(Optional.of(p1));
        personController.deletePerson(1L);
        Mockito.verify(personService, Mockito.times(1)).deletePerson(1L);

    }

}
