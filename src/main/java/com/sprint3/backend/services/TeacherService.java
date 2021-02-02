package com.sprint3.backend.services;

import java.util.List;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import org.springframework.data.domain.Pageable;

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
    // Create by: Đạt
    List<Teacher> findAllTeacher();

    /**
     * quoc sử dụng
     * @param id
     * @return Teacher
     */
    Teacher findTeacherById(Long id);

    /**
     * Lành start
     * @param id
     * @return teacher
     */
    Teacher findByTeacherId(Long id);

    /**
     * lành end
     */

    void saveTeacher(Teacher teacher);

    List<Teacher> search(String input, String key, Pageable pageable);
    /*Get id teacher*/
    Long getIdTeacher(Long id);
}
