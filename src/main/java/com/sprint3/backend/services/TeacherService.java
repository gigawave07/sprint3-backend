package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(Long id);

    Student findStudentCurrentlyLoggingById(Long idStudent);

    //Đếm số lượng sv
    List<StudentGroupDTO> countQuantityStudent();
}
