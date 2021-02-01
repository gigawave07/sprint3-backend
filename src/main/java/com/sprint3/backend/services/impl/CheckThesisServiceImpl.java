package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.repository.CheckThesisRepository;
import com.sprint3.backend.services.CheckThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckThesisServiceImpl implements CheckThesisService {
    @Autowired
    private CheckThesisRepository checkThesisRepository;

    // ------------------- VInh start --------------------------
    @Override
    public void save(CheckThesis checkThesis) {
        this.checkThesisRepository.save(checkThesis);
    }

    @Override
    public CheckThesis findById(Long id) {
        return this.checkThesisRepository.findById(id).orElse(null);
    }

    // ------------------- VInh start --------------------------
}
