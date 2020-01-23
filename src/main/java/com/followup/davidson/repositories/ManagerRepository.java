package com.followup.davidson.repositories;

import com.followup.davidson.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
