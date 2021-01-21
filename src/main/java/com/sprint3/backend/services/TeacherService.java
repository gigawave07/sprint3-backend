package com.sprint3.backend.services;

import com.sprint3.backend.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(Long id);
}
