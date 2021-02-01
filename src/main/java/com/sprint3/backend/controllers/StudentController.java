package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * search Student no group
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
     * @return studentListNoGr
     */
    @GetMapping("/listAllStudentNoGroup")
    public List<Student> getAllStudentNoGr(){
        try {
            List<Student> studentList = this.studentService.findAllStudentNoGroup();
            return studentList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Quoc Controller
     * getStudent by id
     *
     */
    @GetMapping("/studentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long id) {
        return this.studentService.findById(id);
    }
    // end quoc
}
