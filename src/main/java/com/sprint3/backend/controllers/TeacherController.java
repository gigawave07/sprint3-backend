package com.sprint3.backend.controllers;

import java.util.List;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.every_one.MessageDTO;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * MaiHTQ Start
     * 
     * getListTeacher
     * @return teacherList
     */
    @GetMapping("/list")
    public ResponseEntity<List<Teacher>> getListTeacher() {
        List<Teacher> teacherList = this.teacherService.findAll();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    /**
     * find by Id Teacher
     * @param id
     * @return teacher
     */
    @GetMapping("/find-By-Id/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = this.teacherService.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    /**
     * find Id Student Logging
     * @param idStudent
     * @return student
     */
    @GetMapping("/student-logging/{idStudent}")
    public ResponseEntity<Student> findStudentCurrentlyLoggingById(@PathVariable Long idStudent) {
        Student student = this.teacherService.findStudentCurrentlyLoggingById(idStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /**
     * get List Instructor
     * @return studentGroupList
     */
    @GetMapping("/quantity-student")
    public ResponseEntity<?> getQuantityStudent() {
        List<StudentGroupDTO> studentGroupList = this.teacherService.countQuantityStudent();
        return new ResponseEntity<>(studentGroupList, HttpStatus.OK);
    }

    /**
     * save Instructor
     * @param idTeacher
     * @param idStudent
     */
    @GetMapping("/save-instructor/{idTeacher}/{idStudent}")
    public void signUpTeacher(@PathVariable Long idTeacher, @PathVariable Long idStudent) {
        this.teacherService.signUpTeacher(idTeacher, idStudent);
    }

    /**
     * cancel Teacher
     * @param idStudentGroup
     * @return messageDTO
     */
    @GetMapping("/cancel/{idStudentGroup}")
    public ResponseEntity<MessageDTO> cancelTeacher(@PathVariable Long idStudentGroup) {
        MessageDTO messageDTO = this.teacherService.cancelTeacher(idStudentGroup);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    /**
     * MaiHTQ end
     */
}
