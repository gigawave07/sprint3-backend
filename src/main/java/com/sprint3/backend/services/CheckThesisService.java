package com.sprint3.backend.services;

import com.sprint3.backend.model.CheckThesisDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckThesisService {

    /*List check thesis*/
    List<CheckThesisDTO> getAllCheckThesis(Long idTeacher);

    /*Save check thesis*/
    void saveCheckThesis(LocalDateTime checkDate, Long idCheckThesis);
}
