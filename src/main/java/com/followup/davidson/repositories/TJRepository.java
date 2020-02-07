package com.followup.davidson.repositories;

import com.followup.davidson.model.TJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface TJRepository extends JpaRepository<TJ,Long> {
    @Query(value = "select tarif from public.tj where tj.project_id= :projectId and tj.person_id= :personId",
            nativeQuery = true)
    long TjByProjectAndPerson(long projectId,  long personId);

    @Query(value = "select * from public.tj where tj.project_id= :projectId",
            nativeQuery = true)
    List<TJ> getByProjectId(long projectId);

}
