package com.followup.davidson.services.implementation;

import com.followup.davidson.model.TJ;
import com.followup.davidson.repositories.TJRepository;
import com.followup.davidson.services.ITJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class TJServiceImpl  implements ITJService {
    @Autowired
    private TJRepository tjRepository;
    @Override
    public List<TJ> findAll() {
        return tjRepository.findAll();

    }

    @Override
    public TJ create(TJ tj) {
        return tjRepository.save(tj);    }

    @Override
    public TJ findById(Long id) {
        return tjRepository.findById(id).orElse(new TJ());
    }

    @Override
    public void deleteTj(Long id) {
        tjRepository.deleteById(id);
    }
}
