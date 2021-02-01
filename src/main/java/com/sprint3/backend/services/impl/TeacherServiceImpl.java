package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import com.sprint3.backend.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppAccountRepository appAccountRepository;

    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    /**
     * MaiHTQ start
     *
     * @param id
     * @return teacher
     */
    @Override
    public Teacher findById(Long id) {
        return this.teacherRepository.findById(id).orElse(null);
    }

    /**
     * get list instructor
     *
     * @return list studentGroup
     */
    @Override
    public List<StudentGroupDTO> countQuantityStudent() {
        return this.teacherRepository.countQuantityStudent();
    }

    /**
     * sign Up Instructor
     *
     * @param idTeacher
     * @param idStudent
     */
    @Override
    public void signUpTeacher(Long idTeacher, Long idStudent) {
        Teacher teacher = this.teacherRepository.findById(idTeacher).orElse(null);
        Student student = this.studentRepository.findById(idStudent).orElse(null);
        StudentGroup studentGroup = new StudentGroup();
        if (student != null) {
            studentGroup = student.getStudentGroup();
        }
        studentGroup.setTeacher(teacher);
        this.studentGroupRepository.save(studentGroup);
    }

    /**
     * find IdStudent Logging
     *
     * @param idStudent
     * @return
     */
    @Override
    public Student findStudentCurrentlyLoggingById(Long idStudent) {
        return this.studentRepository.findById(idStudent).orElse(null);
    }

    /**
     * cancel Teacher
     *
     * @param idStudentGroup
     * @return
     */
    @Override
    public MessageDTO cancelTeacher(Long idStudentGroup) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            StudentGroup studentGroup = this.studentGroupRepository.findById(idStudentGroup).orElse(null);
            if (studentGroup != null) {
                studentGroup.setTeacher(null);
                this.studentGroupRepository.save(studentGroup);
                messageDTO.setMessage("Complete");
            } else {
                messageDTO.setMessage("Failed");
            }
        } catch (RuntimeException runtimeException) {
            messageDTO.setMessage("Error");
        }
        return messageDTO;
    }

    /**
     * MaiHTQ end
     */
    // Create by: Đạt
     @Override
    public List<Teacher> findAllTeacher() {
        return this.teacherRepository.findAll();
    }


    /**
     * Quoc sử dụng để lấy thông tin giáo viên tạo nhóm
     */
    @Override
    public Teacher findTeacherById(Long id) {
        return this.teacherRepository.findById(id).orElse(null);
    }
    // end quốc

    /**
     * Lành merge thêm 5k
     * @param id
     * @return
     */
    @Override
    public Teacher findByTeacherId(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }


    @Override
    public void saveTeacher(Teacher teacher) {
        try {
            this.teacherRepository.save(teacher);
            AppAccount appAccount = new AppAccount();
            appAccount.setAppRole(this.appRoleRepository.findById((long) 1).orElse(null));
            appAccount.setUsername(teacher.getTeacherCode());
            appAccount.setPassword("123");
            appAccount.setEnabled(true);
            this.appAccountRepository.save(appAccount);
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }

    }

    @Override
    public List<Teacher> search(String input, String key, Pageable pageable) {
        switch (input) {
            case "fullName":
                return teacherRepository.getTeachersByName(key);
            case "teacherCode":
                return teacherRepository.getTeachersByTeacherCode(key);
            case "email":
                return teacherRepository.getTeachersByEmail(key);
            case "identityNumber":
                return teacherRepository.getTeachersByIdNumber(key);
            case "phone":
                return teacherRepository.getTeachersByPhone(key);
        }
        return null;
    }
}
