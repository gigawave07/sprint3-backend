package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Instruction;
import com.sprint3.backend.repository.InstructionRepository;
import com.sprint3.backend.services.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InstructionServiceImpl implements InstructionService {

    // --------------------------- Vinh start --------------------------------
    @Autowired
    private InstructionRepository instructionRepository;

    @Override
    public void save(Instruction instruction) {
        this.instructionRepository.save(instruction);
    }

    @Override
    public List<Instruction> findAllByPeriod(LocalDate startDate, LocalDate endDate) {
        return this.instructionRepository.findAllByPeriod(startDate, endDate);
    }

    @Override
    public void delete(Long id) {
        this.instructionRepository.delete(id);
    }
    // --------------------------- Vinh end --------------------------------
}
