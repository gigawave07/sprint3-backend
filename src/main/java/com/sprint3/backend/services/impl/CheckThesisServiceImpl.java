package com.sprint3.backend.services.impl;

import org.springframework.stereotype.Service;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.repository.CheckThesisReository;
import com.sprint3.backend.services.CheckThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckThesisServiceImpl implements CheckThesisService {
    @Autowired
    private CheckThesisReository checkThesisReository;

    // ------------------- VInh start --------------------------
    @Override
    public void save(CheckThesis checkThesis) {
        this.checkThesisReository.save(checkThesis);
    }

    @Override
    public CheckThesis findById(Long id) {
        return this.checkThesisReository.findById(id).orElse(null);
    }

    // ------------------- VInh start --------------------------
}
