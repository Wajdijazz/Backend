package com.followup.davidson.controllerTests;


import com.followup.davidson.controllers.ClientController;
import com.followup.davidson.model.Client;
import com.followup.davidson.services.IClientService;
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
public class ClientControllerTest {

    private static Client c1;
    private static Client c2;

    @Mock
    private IClientService clientService;

    @InjectMocks
    private ClientController clientController;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        c1=new Client(1L,"Wajdi","Jaziri");
        c2=new Client(2L,"test","test");
    }

    @Test
    void findAll_whenNoRecord() {

        Mockito.when(clientService.findAll()).thenReturn(Arrays.asList());
        assertThat(clientController.getAllClient().size(), is(0));
        Mockito.verify(clientService, Mockito.times(1)).findAll();
    }
    @Test
    void findAll_whenRecord() {

        Mockito.when(clientService.findAll()).thenReturn(Arrays.asList(c1, c2));
        assertThat(clientController.getAllClient().size(), is(2));
        Mockito.verify(clientService, Mockito.times(1)).findAll();
    }

    @Test
    void create() {

        Client c= clientController.createClient(c1);
        Mockito.verify(clientService, Mockito.times(1)).create(c1);


    }
    @Test
    void findById_WhenMatch() {

        Mockito.when(clientService.findById(1L)).thenReturn(Optional.of(c1));
        Optional<Client> c = clientController.findClientById(1L);
        assertThat(c.get(), is(c1) );


    }
    @Test
    void deleteById_WhenFound() {

        lenient().when(clientService.findById(1L)).thenReturn(Optional.of(c1));
        clientController.deleteClient(1L);
        Mockito.verify(clientService, Mockito.times(1)).deleteClient(1L);

    }

}
