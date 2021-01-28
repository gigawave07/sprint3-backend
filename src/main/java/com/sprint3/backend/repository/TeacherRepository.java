package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    /**
     * Nhật start
     */
    @Query(nativeQuery = true, value = "SELECT * FROM teacher where app_account_id = ?;")
    Teacher getTeacherInfoByIDAccount(Long idAccount);
}
