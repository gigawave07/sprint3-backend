package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.StudentDTO;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();

    Student findByID(Long id);

    void delete(Long id);

    void saveStudent(StudentDTO studentDTO);

    List<Student> searchStudent(String inputSearch);

    void save(Student student);
}
