package com.followup.davidson.controllerTests;


import com.followup.davidson.controllers.PersonController;
import com.followup.davidson.model.Person;
import com.followup.davidson.services.IPersonService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PersonControllerTest {

    private static Person m1;
    private static Person m2;

    @Mock
    private IPersonService personService;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void findAll_whenNoRecord() {

        Mockito.when(personService.findAll()).thenReturn(Arrays.asList());
        assertThat(personController.getAllPerson().size(), is(0));
        Mockito.verify(personService, Mockito.times(1)).findAll();
    }
}
