package com.sprint3.backend.services;

import com.sprint3.backend.entity.PeriodOfTime;

import java.time.LocalDate;
import java.util.List;

public interface PeriodOfTimeService {
    // ----------------- Vinh start -------------------------
    List<PeriodOfTime> findAll();

    PeriodOfTime findByDate(String date);
    // ----------------- Vinh end -------------------------
}
