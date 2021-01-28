package com.sprint3.backend.services;

import com.sprint3.backend.entity.Teacher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TeacherService {
    List<Teacher> findAll();
    Teacher findByID(Long id);
    void saveTeacher (Teacher teacher);
    List<Teacher> search(String input, String key, Pageable pageable);
    List<Teacher> get(String inputCompare);
}
