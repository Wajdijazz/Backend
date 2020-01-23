package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Manager;
import com.followup.davidson.repositories.ManagerRepository;
import com.followup.davidson.services.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerRepository managerRepository;


    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findById(id).orElse(new Manager());
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);

    }
}
