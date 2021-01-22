package com.sprint3.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.repository.CheckThesisReository;
import com.sprint3.backend.services.CheckThesisService;

@Service
public class CheckThesisServiceImpl implements CheckThesisService {

    @Autowired
    private CheckThesisReository checkThesisReository;

    @Override
    public List<CheckThesis> findAll() {
        return this.checkThesisReository.findAll();
    }
}
