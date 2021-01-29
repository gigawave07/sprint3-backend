package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * Quoc Controller
     */
    @GetMapping("/studentNoGroup")
    public List<Student> getAllStudentNoGroup(
                                              @RequestParam String by,
                                              @RequestParam String search) {
        List<Student> students = this.studentService.search(search, by);
        return students;
    }

    /**
     * Quoc Controller
     */
    @GetMapping("/studentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long id) {
        return this.studentService.findById(id);
    }
}
