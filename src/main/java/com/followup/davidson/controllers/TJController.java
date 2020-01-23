package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.TJ;
import com.followup.davidson.services.ITJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Routes.TJ)
public class TJController {


    @Autowired
    private ITJService tjService;

    @GetMapping("/")
    public List<TJ> getTj() {
        return tjService.findAll();
    }


    @PostMapping("/")
    public TJ createTj(@Valid @RequestBody TJ tj) {
        return tjService.create(tj);
    }

    @GetMapping("/{id}")
    public TJ findTjById(@PathVariable(value = "id") Long tjId) {
        return tjService.findById(tjId);

    }

    @DeleteMapping("/{id}")
    public void deleteTj(@PathVariable(value = "id") Long tjId) {
        tjService.deleteTj(tjId);

    }
}
