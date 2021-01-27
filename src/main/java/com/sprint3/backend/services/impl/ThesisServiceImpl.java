package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.repository.ThesisRepository;
import com.sprint3.backend.services.TeacherService;
import com.sprint3.backend.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ThesisServiceImpl implements ThesisService {
    //    Đạt
    @Autowired
    private ThesisRepository thesisRepository;
    @Override
    public List<Thesis> findAllThesis() {
        return this.thesisRepository.findAll();
    }
}

