package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Manager;
import com.followup.davidson.repositories.ManagerRepository;
import com.followup.davidson.services.IManagerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ManagerServiceImpl implements IManagerService {


    private ManagerRepository managerRepository;

    public ManagerServiceImpl( ManagerRepository managerRepository) {
        this.managerRepository=managerRepository;
    }

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return managerRepository.findById(id);
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);

    }
}
