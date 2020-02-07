package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Client;
import com.followup.davidson.model.Manager;
import com.followup.davidson.services.IClientService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.CLIENT)
public class ClientController {

    private IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<Client> getAllClient() {
        return clientService.findAll();
    }

    @PostMapping("/")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> findClientById(@PathVariable(value = "id") Long clientId) {
        return clientService.findById(clientId);
    }

    @Transactional
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable(value = "id") Long id, @RequestBody Client client)
    {
        return clientService.update(id,client);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(value = "id") Long clientId) {
        clientService.deleteClient(clientId);
    }

}
