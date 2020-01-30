package com.followup.davidson.servicesTests;


import com.followup.davidson.model.Client;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.services.implementation.ClientServiceImpl;
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
public class ClientServiceTest {

    private static Client c1;
    private static Client c2;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks

    private ClientServiceImpl clientService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    public static void init() {
        c1=new Client(1L,"Decathlon","decathlon@gmail.com");
        c2=new Client (1L,"Elivia","elivia@gamil.com");
    }
    @Test
    public void findAllTest_WhenNoRecord() {

        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList());
        assertThat(clientService.findAll().size(), is(0));
        Mockito.verify(clientRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void findAllTest_WhenRecord() {
        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
        assertThat(clientService.findAll().size(), is(2));
        assertThat(clientService.findAll().get(0), is(c1));
        assertThat(clientService.findAll().get(1),is(c2));
        Mockito.verify(clientRepository, Mockito.times(3)).findAll();

    }

    @Test
    public void findById() {

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(c1));
        assertThat(clientService.findById(1L), is(Optional.of(c1)));
        Mockito.verify(clientRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void deleteById() {
        clientService.deleteClient(1L);
        Mockito.verify(clientRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void create() {

        Mockito.when(clientRepository.save(c1)).thenReturn(c1);
        assertThat(clientService.create(c1), is(c1));
        Mockito.verify(clientRepository, Mockito.times(1)).save(c1);

        Mockito.when(clientRepository.save(c2)).thenReturn(c2);
        assertThat(clientService.create(c2), is(c2));
        Mockito.verify(clientRepository, Mockito.times(1)).save(c2);
    }
}
