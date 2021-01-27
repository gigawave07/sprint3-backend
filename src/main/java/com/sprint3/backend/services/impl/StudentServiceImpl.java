package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.StudentDTO;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.StudentService;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findByID(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }



    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentCode(studentDTO.getStudentCode());
        student.setFullName(studentDTO.getFullName());
        student.setTeacher(studentDTO.getTeacher());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setTopic(studentDTO.getTopic());
        this.studentRepository.save(student);
    }
    @Override
    public List<Student> searchStudent(String inputSearch) {
        return studentRepository.findAllByFullNameContainingOrStudentCode(inputSearch, inputSearch);
    }
}
