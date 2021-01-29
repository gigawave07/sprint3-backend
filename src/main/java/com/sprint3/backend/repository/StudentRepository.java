package com.sprint3.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Quoc Repository
     * @return
     */
    @Query(value="select * from student where student.group_id is null",nativeQuery = true)
    List<Student> findAllStudentNoGroup();
    @Query(value="select * from  project3_thesis_management.student  where student.group_id is null and  (project3_thesis_management.student.email like %?1% or project3_thesis_management.student.full_name like %?1% or project3_thesis_management.student.student_code like %?1% )  " , nativeQuery = true)
    List<Student> findStudentNoGroupByEmailAndStudentCodeAndFullName(String search);
    @Query(value="select * from  student  where student.group_id is null and student.email like %?1%" , nativeQuery = true)
    List<Student> findStudentNoGroupByEmail(String search);
    @Query(value="select * from  student  where student.group_id is null and student.full_name like %?1%" , nativeQuery = true)
    List<Student> findStudentNoGroupByFullName(String fullName);
    @Query(value="select * from  student  where student.group_id is null and student.student_code like %?1%" , nativeQuery = true)
    List<Student> findStudentNoGroupByStudentCode(String studentCode);
}
