package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.StudentDTO;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Create by: Đạt _ Get List Student
    @GetMapping("/list")
    public ResponseEntity<List<Student>> getListStudent() {
        List<Student> listStudent = this.studentService.findAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }
    // Create by: Đạt _ Add new Student
    @PostMapping("/addNew")
    public ResponseEntity<StudentDTO> AddNewStudent(@RequestBody StudentDTO studentDTO) {
        this.studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/inputSearch")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam("valueSearch") String inputSearch) {
        List<Student> studentList = studentService.searchStudent(inputSearch);
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
