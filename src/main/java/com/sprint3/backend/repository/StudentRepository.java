package com.sprint3.backend.repository;

import com.sprint3.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // -------------- VInh start ---------------------------------
    Student findByAppAccountId(Long accountId);
    // -------------- VInh start ---------------------------------
}
