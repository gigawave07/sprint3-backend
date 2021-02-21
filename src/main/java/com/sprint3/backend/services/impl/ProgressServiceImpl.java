package com.sprint3.backend.services.impl;

import com.sprint3.backend.model.ProgressDTO;
import com.sprint3.backend.repository.ProgressThesisRepository;
import com.sprint3.backend.services.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Autowired
    private ProgressThesisRepository progressThesisRepository;

    @Override
    public ProgressDTO getNameThesisByIdStudent(Long idStudent, Long progressThesis) {
        return this.progressThesisRepository.getNameThesisByIdStudent(idStudent, progressThesis);
    }
}
