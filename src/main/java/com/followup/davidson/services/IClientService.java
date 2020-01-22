package com.followup.davidson.services;

import com.followup.davidson.model.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();
    Client findById(Long id);
    Client create(Client client);
    void deleteClient(Long id);
}
