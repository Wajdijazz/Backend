package com.followup.davidson.controllers;


import com.followup.davidson.model.TJ;
import com.followup.davidson.services.ITJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class TJController {


    @Autowired
    private ITJService tjService;

    @GetMapping("/tjs")
    public List<TJ> getTj() {
        return tjService.findAll();
    }


    @PostMapping("/tjs")
    public TJ createTj(@Valid @RequestBody TJ tj) {
        return tjService.create(tj);
    }

    @GetMapping("/tj/{id}")
    public TJ findTjById(@PathVariable(value = "id") Long tjId) {
        return tjService.findById(tjId);

    }

    @DeleteMapping("/tj/{id}")
    public void deleteTj(@PathVariable(value = "id") Long tjId) {
        tjService.deleteTj(tjId);

    }
}