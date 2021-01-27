package com.sprint3.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint3.backend.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Create by: Đạt _  Search Student
    List<Student> findAllByFullNameContainingOrStudentCode(String fullName, String studentCode);
}
