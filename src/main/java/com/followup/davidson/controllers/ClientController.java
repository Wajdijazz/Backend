package com.followup.davidson.controllers;


import com.followup.davidson.model.Client;
import com.followup.davidson.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class ClientController {


    @Autowired
    private IClientService clientService;
    @GetMapping("/clients")
    public List<Client> getAllClient() {
        return clientService.findAll();
    }


    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/client/{id}")
    public Client findClientById(@PathVariable(value = "id") Long clientId)
    {
        return clientService.findById(clientId);

    }
    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable(value = "id") Long clientId)
    {
        clientService.deleteClient(clientId);
    }

}
