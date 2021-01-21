package com.sprint3.backend.controllers;

import com.sprint3.backend.model.StudentDTO;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*List student*/
    @RequestMapping(value = "/list-student/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StudentDTO>> getAllStudent(@PathVariable String id) {
        List<StudentDTO> studentList = this.studentService.getAllStudent(id);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
