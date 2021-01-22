package com.sprint3.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.SubscribeThesisService;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.SubscribeThesisDTO;
import com.sprint3.backend.repository.CheckThesisRepository;
import com.sprint3.backend.repository.ThesisRepository;
import com.sprint3.backend.entity.CheckThesis;

@Service
public class SubscribeThesisServiceImpl implements SubscribeThesisService {
    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private CheckThesisRepository checkThesisRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<CheckThesis> findAllCheckThesisForMail() {
        return this.checkThesisRepository.findAll();
    }

    @Override
    public List<Thesis> findAllThesisByIdTeacher(Long idStudent) {
        Long idTeacher = null;
        Student student = this.studentRepository.findById(idStudent).orElse(null);
        List<Thesis> thesisListResult = new ArrayList<>();
        List<Thesis> thesisListExists = this.thesisRepository.findAll();
        if (student != null) {
            idTeacher = student.getStudentGroup().getTeacher().getId();
        }
        if (idTeacher != null) {
            for (Thesis thesis : thesisListExists) {
                if (thesis.getTeacher().getId().equals(idTeacher)) {
                    thesisListResult.add(thesis);
                }
            }
        }
        return thesisListResult;
    }

    @Override
    public Thesis findThesisById(Long idThesis) {
        return this.thesisRepository.findById(idThesis).orElse(null);
    }

    @Override
    public void saveCheckThesis(SubscribeThesisDTO subscribeThesisDTO) {

    }
}
