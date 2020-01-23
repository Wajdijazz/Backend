package com.followup.davidson.services;

import com.followup.davidson.model.Manager;

import java.util.List;

public interface IManagerService {
    List<Manager> findAll();
    Manager create(Manager manager);
    Manager findById(Long id);
    void deleteManager(Long id);
}
