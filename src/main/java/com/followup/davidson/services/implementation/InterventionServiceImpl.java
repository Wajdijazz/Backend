package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.repositories.InterventionRepository;
import com.followup.davidson.services.IInterventionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InterventionServiceImpl implements IInterventionService {

    InterventionRepository interventionRepository;

    public InterventionServiceImpl(  InterventionRepository interventionRepository) {
        this.interventionRepository=interventionRepository;
    }

    @Override
    public List<Intervention> findAll() {
        return interventionRepository.findAll();    }

    @Override
    public Intervention create(Intervention intervention) {
        this.workedDay(intervention);
        return interventionRepository.save(intervention);
    }

    @Override
    public Optional<Intervention> findById(Long id) {
        return interventionRepository.findById(id);
    }

    @Override
    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);

    }

    @Override
    public void workedDay(Intervention intervention) {
        Date firstDate =intervention.getStartDate();
        Date secondDate =intervention.getEndDate();


        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(firstDate);
        cal2.setTime(secondDate);

       long numberOfDays = 1;
        while (cal1.before(cal2)) {
            if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
                    &&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
            cal1.add(Calendar.DATE,1);

        }

        intervention.setWorked(numberOfDays);
    }





}
