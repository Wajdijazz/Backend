package com.followup.davidson.services;

import com.followup.davidson.model.TJ;

import java.util.List;

public interface ITJService {

    List<TJ> findAll();
    TJ create(TJ tj);
    TJ findById(Long id);
    void deleteTj(Long id);
}
