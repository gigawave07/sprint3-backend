package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    // Create by: Đạt
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> findAllTeacher() {
        return this.teacherRepository.findAll();
    }
}
