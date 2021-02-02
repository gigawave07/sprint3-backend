package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentDTODanh;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.StudentDTO;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    // Create by: Đạt
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
    public void delete(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void editStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentCode(studentDTO.getStudentCode().trim());
        student.setFullName(studentDTO.getFullName().trim());
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

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }
    @Override
    public List<Student> findAllStudentNoGroup() {
        return this.studentRepository.findAllStudentNoGroup();
    }

    /**
     * Quoc Service
     *
     * @param
     * @return Student
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
    /**
     * Quoc Service
     *
     * @param id
     * @return Student
     */
    @Override
    public Student findById(Long id) {

        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveQuoc(Student student) {
        return this.studentRepository.save(student);
    }
    //end quoc

      // ---------------------- VInh start ---------------------------
    @Override
    public Student findStudentById(Long studentId) {
        return this.studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student findStudentByAccountId(Long accountId) {
        return this.studentRepository.findByAppAccountId(accountId);
    }

    // ---------------------- VInh end ---------------------------

    /*List student*/
    @Override
    public List<StudentDTODanh> getAllStudent(Long id) {
        return this.studentRepository.getAllStudent(id);
    }
}
