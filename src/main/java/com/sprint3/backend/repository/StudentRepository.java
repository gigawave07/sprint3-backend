package com.sprint3.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
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
    /**
     * Lành end
     */

    /**
     * Nhật start
     */
    @Query(nativeQuery = true, value = "select s.*\n" +
            "from student s\n" +
            "inner join student_group sg on s.group_id = sg.id\n" +
            "inner join teacher t on sg.teacher_id = t.id\n" +
            "inner join app_account acc on t.app_account_id = acc.id\n" +
            "where acc.id = ?;")
    List<Student> getListStudentByAppAccountID(Long idTeacher);
    /**
     * Nhật end
     */
    // Create by: Đạt _  Search Student
    List<Student> findAllByFullNameContainingOrStudentCode(String fullName, String studentCode);
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
    // end quoc
    // -------------- VInh start ---------------------------------
    Student findByAppAccountId(Long accountId);
    // -------------- VInh start ---------------------------------
}
