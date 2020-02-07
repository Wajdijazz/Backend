package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Manager;
import com.followup.davidson.services.IManagerService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.Manger)
public class ManagerController {

    private IManagerService managerService;

    public ManagerController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/")
    public List<Manager> getAllManager() {
        return managerService.findAll();
    }


    @PostMapping("/")
    public Manager createManager(@Valid @RequestBody Manager manager) {
        return managerService.create(manager);
    }

    @GetMapping("/{id}")
    public Optional<Manager> findManagerById(@PathVariable(value = "id") Long managerId) {
        return managerService.findById(managerId);
    }

    @Transactional
    @PutMapping("/{id}")
    public Manager updateManager(@PathVariable(value = "id") Long id, @RequestBody Manager manager)
    {
        return managerService.update(id,manager);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable(value = "id") Long managerId) {
        managerService.deleteManager(managerId);
    }

}
