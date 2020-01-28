package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Client;
import com.followup.davidson.repositories.ClientRepository;
import com.followup.davidson.services.IClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ClientServiceImpl implements IClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository=clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
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
