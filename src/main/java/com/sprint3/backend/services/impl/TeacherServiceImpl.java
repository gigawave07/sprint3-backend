package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    /**
     * Lành start
     * 
     */

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher findByTeacherId(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    /**
     * Lành end
     */
}
