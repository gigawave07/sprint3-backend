package com.sprint3.backend.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sprint3.backend.entity.Teacher;

@Service
public interface TeacherService {
    List<Teacher> findAll();

    void saveTeacher(Teacher teacher);

    List<Teacher> search(String input, String key, Pageable pageable);
}
