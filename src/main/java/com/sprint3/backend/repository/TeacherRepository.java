package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.sprint3.backend.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "select * from teacher where teacher.full_name like %?1%", nativeQuery = true)
    List<Teacher> getTeachersByName(String string);

    @Query(value = "select * from teacher where teacher_code like %?1%", nativeQuery = true)
    List<Teacher> getTeachersByTeacherCode(String string);

    @Query(value = "select * from teacher where teacher.identity_number like %?1%", nativeQuery = true)
    List<Teacher> getTeachersByIdNumber(String string);

    @Query(value = "select * from teacher where teacher.email like %?1%", nativeQuery = true)
    List<Teacher> getTeachersByEmail(String string);

    @Query(value = "select * from teacher where teacher.phone like %?1%", nativeQuery = true)
    List<Teacher> getTeachersByPhone(String string);

    @Query(value = "select teacher_code from teacher where teacher_code like %?1%", nativeQuery = true)
    List<Teacher> getTeacherCode(String string);
}
