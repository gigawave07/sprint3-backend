package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Teacher;
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

    @GetMapping("/list")
    public ResponseEntity<List<Teacher>> getListEmployee() {
        List<Teacher> teacherList = this.teacherService.findAll();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/find-By-Id/{id}")
    public ResponseEntity<Teacher> getEmployeeById(@PathVariable Long id) {
        Teacher teacher = this.teacherService.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
