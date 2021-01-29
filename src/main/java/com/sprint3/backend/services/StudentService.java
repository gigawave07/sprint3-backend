package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    /**
     * Quoc Service
     * @param
     * @return
     */
    List<Student> findAllStudentNoGroup();

    List<Student> search(String search, String by);

    Student findById(Long id);
    Student save(Student student);

    // end Service

}
