package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.Client;
import com.followup.davidson.model.Manager;
import com.followup.davidson.services.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Routes.Manger)
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    @GetMapping("/")
    public List<Manager> getAllManager() {
        return managerService.findAll();
    }


    @PostMapping("/")
    public Manager createManager(@Valid @RequestBody Manager manager) {
        return managerService.create(manager);
    }

    @GetMapping("/{id}")
    public Manager findManagerById(@PathVariable(value = "id") Long managerId)
    {
        return managerService.findById(managerId);

    }
    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable(value = "id") Long managerId)
    {
        managerService.deleteManager(managerId);
    }

}
