package com.followup.davidson.servicesTests;

import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.repositories.ProjectRepository;
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

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProjectServiceTest {
    private static Project p1;
    private static Project p2;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks

    private ProjectServiceImpl projectService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        p1=new Project(1L,"Followup",null);
        p2=new Project(1L,"ERP",null);

    }
    @Test
    public void findAllTest_WhenNoRecord() {

        Mockito.when(projectRepository.findAll()).thenReturn(Arrays.asList());
        assertThat(projectService.findAll().size(), is(0));
        Mockito.verify(projectRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(projectRepository.findAll()).thenReturn(Arrays.asList(p1, p2));
        assertThat(projectService.findAll().size(), is(2));
        assertThat(projectService.findAll().get(0), is(p1));
        assertThat(projectService.findAll().get(1),is(p2));
        Mockito.verify(projectRepository, Mockito.times(3)).findAll();

    }

    @Test
    public void findById() {

        Mockito.when(projectRepository.findById(1L)).thenReturn(Optional.of(p1));
        assertThat(projectService.findById(1L), is(Optional.of(p1)));
        Mockito.verify(projectRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void deleteById() {
        projectService.deleteProject(1L);
        Mockito.verify(projectRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void create() {

        Mockito.when(projectRepository.save(p1)).thenReturn(p1);
        assertThat(projectService.create(p1), is(p1));
        Mockito.verify(projectRepository, Mockito.times(1)).save(p1);

        Mockito.when(projectRepository.save(p2)).thenReturn(p2);
        assertThat(projectService.create(p2), is(p2));
        Mockito.verify(projectRepository, Mockito.times(1)).save(p2);
    }
}
