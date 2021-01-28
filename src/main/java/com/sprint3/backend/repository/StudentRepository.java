package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Lành start
     */

    @Query(nativeQuery = true, value = "SELECT * FROM student where group_id =?;")
    List<Student> getListStudentByGroupID(Long idGroup);


    @Modifying
    @Query(nativeQuery = true, value = "UPDATE student SET group_id = null WHERE id = ?;")
    Student resetIDGroup(Long id);

    /**
     * Lành end
     */
}
