package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // -------------- VInh start ---------------------------------
    Student findByAppAccountId(Long accountId);
    // -------------- VInh start ---------------------------------
}
