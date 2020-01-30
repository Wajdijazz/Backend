package com.followup.davidson.repositories;


import com.followup.davidson.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface InterventionRepository  extends JpaRepository<Intervention,Long> {

    @Query(value="select * from public.intervention " , nativeQuery = true)
    List<Intervention> findAll();

    @Query(value="select * from intervention where intervention.person_id= :person_id and intervention.project_id= :project_id ", nativeQuery = true)
    List<Intervention> findByPersonAndProject(@Param("project_id") long project_id,@Param("person_id")  long person_id);

    @Query(value="select count(*) from public.intervention where intervention.person_id= :person_id and intervention.project_id= :project_id and intervention.date between :firstDate AND :secondDate" , nativeQuery = true)
    long workedDaysByPeriod(@Param("person_id")  long person_id, @Param("project_id") long project_id , @Param("firstDate") Date firstDate , @Param("secondDate") Date secondDate );

    @Query(value="select count(*) from public.intervention where intervention.person_id= :person_id and intervention.project_id= :project_id ", nativeQuery = true)
    long workedDayByPersonAndProject( @Param("project_id") long project_id,@Param("person_id")  long person_id);
    @Modifying
    @Query(value=" DELETE FROM intervention i WHERE i.person_id= :personId AND i.project_id= :projectId",nativeQuery = true)
    void deleteIntervention( @Param("personId") Long personId,@Param("projectId") Long projectId);
}

