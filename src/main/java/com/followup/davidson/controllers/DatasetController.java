package com.followup.davidson.controllers;


import com.followup.davidson.Routes;
import com.followup.davidson.model.DataSet;
import com.followup.davidson.services.IDataSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("data")
public class DatasetController {
     private IDataSetService dataSetService;


    public DatasetController(IDataSetService dataSetService) {
        this.dataSetService = dataSetService;
    }

    @GetMapping("/{projectId}/")
    public DataSet getDataset(@PathVariable(value = "projectId") Long projectId) {
        return dataSetService.getDataSets(projectId);
    }
}
