package com.followup.davidson.repositories;


import com.followup.davidson.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository  extends JpaRepository<Client,Long> {
}
