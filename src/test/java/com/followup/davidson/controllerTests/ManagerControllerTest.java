package com.followup.davidson.controllerTests;


import com.followup.davidson.controllers.ManagerController;
import com.followup.davidson.model.Manager;
import com.followup.davidson.services.IManagerService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ManagerControllerTest {
    private static Manager m1;
    private static Manager m2;

    @Mock
    private IManagerService managerService;

    @InjectMocks
    private ManagerController managerController;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        m1=new Manager(1L,"Wajdi","Jaziri");
        m2=new Manager(2L,"test","test");
    }


    @Test
    void findAll_whenNoRecord() {

        Mockito.when(managerService.findAll()).thenReturn(Arrays.asList());
        assertThat(managerController.getAllManager().size(), is(0));
        Mockito.verify(managerService, Mockito.times(1)).findAll();
    }
    @Test
    void findAll_whenRecord() {

        Mockito.when(managerService.findAll()).thenReturn(Arrays.asList(m1, m2));
        assertThat(managerController.getAllManager().size(), is(2));
        Mockito.verify(managerService, Mockito.times(1)).findAll();
    }
    @Test
    void create() {

        Manager m= managerController.createManager(m1);
        Mockito.verify(managerService, Mockito.times(1)).create(m1);


    }
    @Test
    void findById_WhenMatch() {

        Mockito.when(managerService.findById(1L)).thenReturn(Optional.of(m1));
        Optional<Manager> m = managerController.findManagerById(1L);
        assertThat(m.get(), is(m1) );


    }
    @Test
    void deleteById_WhenFound() {

        lenient().when(managerService.findById(1L)).thenReturn(Optional.of(m1));
        managerController.deleteManager(1L);
        Mockito.verify(managerService, Mockito.times(1)).deleteManager(1L);

    }


}




