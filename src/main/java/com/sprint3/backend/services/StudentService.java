package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.StudentDTO;

import java.util.List;

public interface StudentService {
    // Create by: Đạt _ Student
    List<Student> findAllStudent();

    Student findByID(Long id);

    void delete(Long id);

    void saveStudent(StudentDTO studentDTO);

    List<Student> searchStudent(String inputSearch);

    void editStudent(Student student);

    void save(Student student);
    /**
     * Quoc Service
     * @param
     * @return
     */
    List<Student> findAllStudentNoGroup();

    List<Student> search(String search, String by);

    Student findById(Long id);
    Student saveQuoc(Student student);

    // end Service

    // ---------------------- VInh start ---------------------------
    Student findStudentById(Long studentId);

    Student findStudentByAccountId(Long accountId);

    // ---------------------- VInh start ---------------------------

    /*List student*/
    List<StudentDTO> getAllStudent(Long id);
}
