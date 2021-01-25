package com.sprint3.backend.controllers;

import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@CrossOrigin
public class StatisticsController {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ThesisRepository thesisRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/teacher")
    public ResponseEntity<?> teacher() {
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @GetMapping("/student")
    public ResponseEntity<?> student() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/thesis")
    public ResponseEntity<?> thesis() {
        return ResponseEntity.ok(thesisRepository.findAll());
    }

    @GetMapping("/checked-thesis")
    public ResponseEntity<?> checkedThesis() {
        return ResponseEntity.ok(thesisRepository.findByCheckThesis_Status(true));
    }

}
