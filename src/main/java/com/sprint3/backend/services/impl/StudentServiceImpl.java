package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    /**
     * Quoc Service
     *
     * @param
     * @return
     */
    @Override
    public List<Student> findAllStudentNoGroup() {
        return this.studentRepository.findAllStudentNoGroup();
    }

    /**
     * Quoc Service
     *
     * @param
     * @return
     */
    @Override
    public List<Student> search(String search, String by) {
//        Page<Student> students = this.studentRepository.findAllStudentNoGroup(pageable);
        List<Student> students = null;
        switch (by) {
            case "all":
                students = this.studentRepository.findStudentNoGroupByEmailAndStudentCodeAndFullName(search);
                break;
            case "fullName":
                students = this.studentRepository.findStudentNoGroupByFullName(search);
                break;
            case "email":
                students = this.studentRepository.findStudentNoGroupByEmail(search);
                break;
            case "studentCode":
                students = this.studentRepository.findStudentNoGroupByStudentCode(search);
                break;
        }
        return students;
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }
}
