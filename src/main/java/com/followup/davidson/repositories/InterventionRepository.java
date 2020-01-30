package com.followup.davidson.repositories;


import com.followup.davidson.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface InterventionRepository  extends JpaRepository<Intervention,Long> {
    /**
     * cette methode permet de lister toutes les interventions enregistrés dans la base de données
     * @return une liste de {@link Intervention}
     */
    @Query(value="select * from public.intervention " , nativeQuery = true)
    List<Intervention> findAll();


    /**
     * cette methode permet de lister toutes les interventions d'une personne  sur un projet
     * @param project_id : l 'id du projet selectioné
     * @param person_id : l'id du personne selectionnée
     * @return une liste des {@link Intervention}
     */
    @Query(value="select * from intervention where intervention.person_id= :person_id and intervention.project_id= :project_id ", nativeQuery = true)
    List<Intervention> findByPersonAndProject(@Param("project_id") long project_id,@Param("person_id")  long person_id);

    /**
     * cette methode permet de lister les interventions d'une personne sur un projet dans une periode bien determinée
     * @param person_id : l'id de la personne selectionée
     * @param project_id : l'id du projet
     * @param firstDate : la date de debut de la periode
     * @param secondDate : la date de fin de la periode
     * @return une liste des {@link Intervention}
     */
    @Query(value="select count(*) from public.intervention where intervention.person_id= :person_id and intervention.project_id= :project_id and intervention.date between :firstDate AND :secondDate" , nativeQuery = true)
    long workedDaysByPeriod(@Param("person_id")  long person_id, @Param("project_id") long project_id , @Param("firstDate") Date firstDate , @Param("secondDate") Date secondDate );

    /**
     *cette methode permet de compter le nombre des jours travaillés d'une personne sur un projet
     * @param project_id
     * @param person_id
     * @return un entier
     */
    @Query(value="select count(*) from public.intervention where intervention.person_id= :person_id and intervention.project_id= :project_id ", nativeQuery = true)
    long workedDayByPersonAndProject( @Param("project_id") long project_id,@Param("person_id")  long person_id);




}

