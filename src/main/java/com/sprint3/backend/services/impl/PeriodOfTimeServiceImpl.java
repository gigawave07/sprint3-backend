package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.PeriodOfTime;
import com.sprint3.backend.repository.PeriodOfTimeRepository;
import com.sprint3.backend.services.PeriodOfTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PeriodOfTimeServiceImpl implements PeriodOfTimeService {
    @Autowired
    private PeriodOfTimeRepository periodOfTimeRepository;

    // ----------------------------- Vinh start-------------------------------
    @Override
    public List<PeriodOfTime> findAll() {
        return this.periodOfTimeRepository.findAll();
    }

    @Override
    public PeriodOfTime findByDate(String date) {
        return this.periodOfTimeRepository.findByDate(date);
    }
    // ----------------------------- Vinh start-------------------------------
}
