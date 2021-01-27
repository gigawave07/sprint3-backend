package com.sprint3.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint3.backend.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFullNameContaining(String fullName);

    Student findByStudentCode(String studentCode);
    List<Student> findAllByFullNameContainingOrStudentCode(String fullName, String studentCode);
}
