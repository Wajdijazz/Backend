package com.followup.davidson.services;

import com.followup.davidson.model.TJ;

import java.util.List;
import java.util.Optional;

public interface ITJService {

    List<TJ> findAll();
    TJ create(TJ tj,Long projectId,Long personId);
    Optional<TJ> findById(Long id);
    void deleteTj(Long id);
}
