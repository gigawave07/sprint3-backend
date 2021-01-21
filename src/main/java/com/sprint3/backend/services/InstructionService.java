package com.sprint3.backend.services;

import com.sprint3.backend.entity.Instruction;

import java.time.LocalDate;
import java.util.List;

public interface InstructionService {

    // --------------------------- Vinh start --------------------------------
    void save(Instruction instruction);

    List<Instruction> findAllByPeriod(LocalDate startDate, LocalDate endDate);

    void delete(Long id);

    // --------------------------- Vinh end  --------------------------------
}
