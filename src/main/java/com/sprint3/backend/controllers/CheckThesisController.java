package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.services.CheckThesisService;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check-thesis")
@CrossOrigin
public class CheckThesisController {
    @Autowired
    private CheckThesisService checkThesisService;

    @Autowired
    private StudentService studentService;

    // ------------------ VInh start -----------------------------
    @PostMapping("/find-by-student/{studentId}")
    public ResponseEntity<?> findByStudentId(@PathVariable Long studentId) {
        ThesisDetail thesisDetail = new ThesisDetail();
        Student student = this.studentService.findStudentById(studentId);
        thesisDetail.setCheckThesis(student.getStudentGroup().getCheckThesis());
        return ResponseEntity.ok(thesisDetail);
    }

//    @GetMapping("/get-list/{studentId}")
//    public ResponseEntity<?> getList(@PathVariable Long studentId){
//
//    }
    // ------------------ VInh start -----------------------------
}
