package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // ---------------------- VInh start ---------------------------
    @Override
    public Student findStudentById(Long studentId) {
        return this.studentRepository.findById(studentId).orElse(null);
    }

    // ---------------------- VInh end ---------------------------
}
