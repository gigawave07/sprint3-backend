package com.sprint3.backend.services;

import java.util.List;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.every_one.MessageDTO;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;

public interface TeacherService {
    /**
     * MaiHTQ start
     */
    List<Teacher> findAll();

    Teacher findById(Long id);

    Student findStudentCurrentlyLoggingById(Long idStudent);

    List<StudentGroupDTO> countQuantityStudent();

    void signUpTeacher(Long idTeacher, Long idStudent);

    MessageDTO cancelTeacher(Long idStudentGroup);

    /**
     * MaiHTQ end
     */
}
