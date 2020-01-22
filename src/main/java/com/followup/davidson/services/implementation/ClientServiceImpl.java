package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Client;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
