package com.sprint3.backend.services.impl;

import com.sprint3.backend.model.CheckThesisDTO;
import com.sprint3.backend.repository.CheckThesisRepository;
import com.sprint3.backend.services.CheckThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckThesisServiceImpl implements CheckThesisService {

    @Autowired
    private CheckThesisRepository checkThesisRepository;

    /*List check thesis*/
    @Override
    public List<CheckThesisDTO> getAllCheckThesis(Long idTeacherParam) {
        return this.checkThesisRepository.getAllCheckThesis(idTeacherParam);
    }

    /*Save check thesis*/
    @Override
    public void saveCheckThesis(LocalDateTime checkDate, Long idCheckThesis) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss");
//        LocalDateTime localFromDay = LocalDateTime.parse(checkDate, formatter);
        this.checkThesisRepository.saveCheckThesis(checkDate, idCheckThesis);
    }

}
