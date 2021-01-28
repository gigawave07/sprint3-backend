package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.repository.CheckThesisReository;
import com.sprint3.backend.services.CheckThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckThesisServiceImpl implements CheckThesisService {
    @Autowired
    private CheckThesisReository checkThesisReository;
    @Override
    public void save(CheckThesis checkThesis) {
        this.checkThesisReository.save(checkThesis);
    }
}
