package com.sprint3.backend.repository;

import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//    @Query(value = "SELECT SUM(project3_thesis_management.student_group.quantity) as quantity," +
//            "project3_thesis_management.student_group.teacher_id as teacherId\n" +
//            "   FROM project3_thesis_management.student_group\n" +
//            "   GROUP BY project3_thesis_management.student_group.teacher_id;", nativeQuery = true)
//    List<StudentGroupDTO> countQuantityStudent();

    @Query(value = "select * from instruction_status", nativeQuery = true)
    List<StudentGroupDTO> countQuantityStudent();
    /**
     * Nhật start
     */
    @Query(nativeQuery = true, value = "SELECT * FROM teacher where app_account_id = ?;")
    Teacher getTeacherInfoByIDAccount(Long idAccount);
}
