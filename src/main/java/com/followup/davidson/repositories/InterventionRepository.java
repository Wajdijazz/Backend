package com.followup.davidson.repositories;


import com.followup.davidson.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InterventionRepository  extends JpaRepository<Intervention,Long> {
}
