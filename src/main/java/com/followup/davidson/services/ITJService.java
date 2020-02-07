package com.followup.davidson.services;

import com.followup.davidson.model.DataSet;
import com.followup.davidson.model.TJ;

import java.util.List;
import java.util.Optional;

public interface ITJService {

    List<TJ> findAll();

    TJ create(TJ tj, Long projectId, Long personId);

    TJ update(Long id, TJ tj, Long projetId, Long personId);

    Optional<TJ> findById(Long id);

    void deleteTj(Long id);

    long TjByProjectAndPerson(long projectId,long personId);

}
