package com.followup.davidson.services.implementation;

import com.followup.davidson.model.Intervention;
import com.followup.davidson.model.Mode;
import com.followup.davidson.model.Person;
import com.followup.davidson.model.Project;
import com.followup.davidson.repositories.InterventionRepository;
import com.followup.davidson.services.IInterventionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Transactional
@Service
public class InterventionServiceImpl implements IInterventionService {

    InterventionRepository interventionRepository;

    public InterventionServiceImpl(InterventionRepository interventionRepository) {
        this.interventionRepository = interventionRepository;
    }

    /**
     * Cette methode permet de retourner une intervention par id
     *
     * @param id
     * @return une intervention
     */
    @Override
    public Optional<Intervention> findById(Long id) {
        return interventionRepository.findById(id);
    }

    /**
     * Cette methode permet de lister tous les interventions
     *
     * @return une liste des {@link Intervention}
     */
    @Override
    public List<Intervention> findAll() {
        return interventionRepository.findAll();
    }

    /**
     * cette methode permet de sauvgarder lhistorique des interventions d'une personne sur un projet par details , les weekend sont
     * automatiquement eliminés
     * elle prend en paramatre , date de debut des interventions et date de fins des interventions
     *
     * @param firstDate
     * @param secondDate
     * @param person
     * @param project
     */
    @Override
    public void saveInterventions(Date firstDate, Date secondDate, Person person, Project project) {
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
            cal1.add(Calendar.DATE, 1);
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    /**
     * Cette methode permet de supprimer tous les interventions par l'id de personne et l'id de projet au méme temps
     *
     * @param personId
     * @param projectId
     */
    @Override
    public void deleteIntervention(Long personId, Long projectId) {
        interventionRepository.deleteIntervention(personId, projectId);
    }

    /**
     * Cette methode permet de supprimer une intervention par id intervention
     *
     * @param id
     */
    @Override
    public void deleteInterventionHistorique(Long id) {
        interventionRepository.deleteById(id);
    }

    /**
     * Cette methode permet de trouver tous les interventions par l'id de personne et l'id de projet au méme temps
     *
     * @param projectId
     * @param personId
     * @return
     */
    @Override
    public List<Intervention> findByPersonAndProject(long projectId, long personId) {
        return interventionRepository.findByPersonAndProject(projectId, personId);
    }

    /**
     * cette methode permet de compter le nombre des jours travaillés d'une personne sur un projet
     *
     * @param projectId
     * @param personId
     * @return un entier
     */
    @Override
    public long workedDayByPersonAndProject(long projectId, long personId) {
        return interventionRepository.workedDayByPersonAndProject(projectId, personId);
    }

}
