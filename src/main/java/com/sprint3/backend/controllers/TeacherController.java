package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.services.StudentService;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    // Create by: Đạt
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/list1")
    public ResponseEntity<?> getListTeacher() {
        List<Teacher> listTeacher = this.teacherService.findAllTeacher();
        return new ResponseEntity<>(listTeacher, HttpStatus.OK);
    }

}
