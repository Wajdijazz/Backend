package com.followup.davidson.services.implementation;


import com.followup.davidson.model.*;
import com.followup.davidson.repositories.TJRepository;
import com.followup.davidson.services.IDataSetService;
import com.followup.davidson.services.IPersonService;
import com.followup.davidson.services.IProjectService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Transactional
@Service
public class DataSetServiceImpl implements IDataSetService {

    private TJRepository tjRepository;
    private IProjectService projectService;
    private IPersonService personService;

    public DataSetServiceImpl(TJRepository tjRepository, IProjectService projectService, IPersonService personService) {
        this.tjRepository = tjRepository;
        this.projectService = projectService;
        this.personService = personService;
    }

    /**
     * Dans cette methode on va recuperer un couple projet et tous les personnes
     * @param projectId
     * @return
     */
    @Override
    public DataSet getDataSets(Long projectId) {

        List<PersonDto> personDtos = new ArrayList<>();
        List<DataSet> dataSets = new ArrayList<>();
        DataSet dataSet = new DataSet();
        List<TJ> tjs = tjRepository.findAll();
        List<TJ> tjId = tjRepository.getByProjectId(projectId);
        tjs.stream().map(tj -> {

            PersonDto personDto = new PersonDto();
            Long personId = tj.getPerson().getPersonId();
            String personName = tj.getPerson().getFirstName();

            tjId.stream().map(tj1 -> {
                        ProjectDto projectDto = new ProjectDto();
                        String projectName = tj1.getProject().getProjectName();
                        projectDto.setProject(projectName);
                        dataSet.setProject(projectDto);
                        return null;
                    }
            ).collect(Collectors.toList());

            personDto.setPersonId(personId);
            personDto.setName(personName);
            personDtos.add(personDto);
            dataSet.setPersons(personDtos);

            return null;
        }).collect(Collectors.toList());

        System.out.println(dataSets);

        return dataSet;
    }

}
