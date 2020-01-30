package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.model.Mode;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.InterventionRepository;
import com.followup.davidson.services.IInterventionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import java.util.stream.Collectors;

@Transactional
@Service
public class InterventionServiceImpl implements IInterventionService {

    InterventionRepository interventionRepository;

    public InterventionServiceImpl(  InterventionRepository interventionRepository) {
        this.interventionRepository=interventionRepository;
    }


    public List<Intervention> findAll() {
     return interventionRepository.findAll();



    }


    @Override
    public Intervention create(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @Override
    public Optional<Intervention> findById(Long id) {
        return interventionRepository.findById(id);
    }

    @Override
    public void saveInterventions(Date firstDate, Date secondDate , Person person , Project project) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(firstDate);
        cal2.setTime(secondDate);


       long numberOfDays = 1;

        while (cal1.before(cal2)) {
            if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                    && (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                Date date = cal1.getTime();
                Intervention intervention1 = new Intervention();
                Intervention intervention2 = new Intervention();
                intervention1.setPerson(person);
                intervention1.setProject(project);
                intervention2.setPerson(person);
                intervention2.setProject(project);
                java.sql.Date sDate = convertUtilToSql(date);
                intervention1.setDate(sDate);
                intervention2.setDate(sDate);
                intervention1.setMode(Mode.AM);
                intervention2.setMode(Mode.PM);
                System.out.println(intervention1);
                System.out.println(intervention2);
                interventionRepository.save(intervention1);
                interventionRepository.save(intervention2);
            }
            cal1.add(Calendar.DATE,1);

        }



    }


    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @Override
    public void deleteIntervention(Long personId,Long projectId) {
        interventionRepository.deleteIntervention(personId,projectId);

    }







}
