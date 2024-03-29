package com.followup.davidson.servicesTests;


import com.followup.davidson.controllers.InterventionController;
import com.followup.davidson.controllers.PersonController;
import com.followup.davidson.controllers.ProjectController;
import com.followup.davidson.model.*;
import com.followup.davidson.repositories.InterventionRepository;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.repositories.ProjectRepository;
import com.followup.davidson.services.implementation.InterventionServiceImpl;
import com.followup.davidson.services.implementation.PersonServiceImpl;
import com.followup.davidson.services.implementation.ProjectServiceImpl;
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

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InterventionServiceTest {
    //preparer les unit test pour service intervention et controller intervention
    private static Intervention int1;
    private static Intervention int2;
    private static Project p1;
    private static Person pe1;
    private static InterventionController.InterventionForm interventionForm;


    @Mock
    private InterventionRepository interventionRepository;
    @InjectMocks
    private InterventionServiceImpl interventionService;
    @Mock
    private ProjectServiceImpl projectService;
    @InjectMocks
    private ProjectController projectController;
    @Mock
    private PersonServiceImpl personService;
    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        int1 = new Intervention(1L, new Date(2020 - 01 - 06), Mode.AM, null, null);
        int2 = new Intervention(1L, new Date(2020 - 01 - 18), Mode.AM, null, null);
        p1 = new Project(1L, "Followup", null);
        pe1 = new Person(1L, "Wajdi", "Jaziri", null);
        interventionForm = new InterventionController.InterventionForm(new Date(2020 - 02 - 03),
                new Date(2020 - 03 - 06), null, null);
    }

    @Test
    public void findAllTest_WhenNoRecord() {
        Mockito.when(interventionRepository.findAll()).thenReturn(Arrays.asList());
        assertThat(interventionService.findAll().size(), is(0));
        Mockito.verify(interventionRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(interventionRepository.findAll()).thenReturn(Arrays.asList(int1, int2));
        assertThat(interventionService.findAll().size(), is(2));
        assertThat(interventionService.findAll().get(0), is(int1));
        assertThat(interventionService.findAll().get(1), is(int2));
        Mockito.verify(interventionRepository, Mockito.times(3)).findAll();
    }

    @Test
    public void findById() {
        Mockito.when(interventionRepository.findById(1L)).thenReturn(Optional.of(int1));

        assertThat(interventionService.findById(1L), is(Optional.of(int1)));
        Mockito.verify(interventionRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void deleteByIdPersonAndProject() {
        interventionService.deleteIntervention(1L, 1L);
        Mockito.verify(interventionRepository, Mockito.times(1)).deleteIntervention(1L, 1L);
    }

    @Test
    void deleteById() {
        interventionService.deleteInterventionHistorique(1L);
        Mockito.verify(interventionRepository, Mockito.times(1)).deleteById(1L);
    }
    @Test
    void create() {
        Mockito.when(projectService.findById(1L)).thenReturn(Optional.of(p1));
        Optional<Project> p = projectController.findProjectById(1L);
        assertThat(p.get(), is(p1) );

        Mockito.when(personService.findById(1L)).thenReturn(Optional.of(pe1));
        Optional<Person> pe = personController.findPersonById(1L);
        assertThat(pe.get(), is(pe1) );
        assertThat(interventionService.saveInterventions(interventionForm,1L,1L), is(interventionForm));
    }

}
