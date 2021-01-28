package com.sprint3.backend.repository;

import com.sprint3.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFullNameContaining(String fullName);

    Student findByStudentCode(String studentCode);
    List<Student> findAllByFullNameContainingOrStudentCode(String fullName, String studentCode);

//    @Query(value="delete from student where student.id = :studentId", nativeQuery = true)
//    @Modifying
//    @Transactional
//    void deleteById(@Param("studentId") Long studentId);
}
