package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.maihtq.StudentGroupDTO;
import com.sprint3.backend.services.StudentGroupService;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("/list")
    public ResponseEntity<List<Teacher>> getListTeacher() {
        List<Teacher> teacherList = this.teacherService.findAll();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/find-By-Id/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = this.teacherService.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/student-logging/{idStudent}")
    public ResponseEntity<Student> findStudentCurrentlyLoggingById(@PathVariable Long idStudent) {
        Student student = this.teacherService.findStudentCurrentlyLoggingById(idStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/quantity-student")
    public ResponseEntity<?> getQuantityStudent() {
        List<StudentGroupDTO> studentGroupList = this.teacherService.countQuantityStudent();
        return new ResponseEntity<>(studentGroupList, HttpStatus.OK);
    }
}
