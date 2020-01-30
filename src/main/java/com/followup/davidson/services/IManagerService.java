package com.followup.davidson.services;

import com.followup.davidson.model.Manager;

import java.util.List;
import java.util.Optional;

public interface IManagerService {
    List<Manager> findAll();
    Manager create(Manager manager);
    Optional<Manager> findById(Long id);
    void deleteManager(Long id);
}
