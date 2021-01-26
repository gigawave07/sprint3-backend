package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import com.sprint3.backend.repository.StudentGroupRepository;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return this.teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<StudentGroupDTO> countQuantityStudent() {
        return this.teacherRepository.countQuantityStudent();
    }

    @Override
    public Student findStudentCurrentlyLoggingById(Long idStudent) {
        return this.studentRepository.findById(idStudent).orElse(null);
    }
}
