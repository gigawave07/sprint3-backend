package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.StudentGroupDTODanh;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.StudentGroupDTO;

import java.util.List;

public interface StudentGroupService {
    /**
     * Lành start
     */

    List<StudentGroupDTO> findAll();

    List<Student> findStudentGroup(Long id);

    MessageDTO setNullStudent(Long id);

    StudentGroup findById(Long id);


    /**
     * Lành end
     */
    StudentGroup save(StudentGroup studentGroup);


    /*List student group*/
    List<StudentGroupDTODanh> findAllStudentGroup(Long id);
}
