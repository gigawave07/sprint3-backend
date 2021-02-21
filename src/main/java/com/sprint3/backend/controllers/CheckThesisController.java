package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.CheckThesisDTODabh;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.services.CheckThesisService;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.model.CheckThesisDTO;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.services.CheckThesisService;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/check-thesis")
@CrossOrigin
public class CheckThesisController {


    @Autowired
    private StudentService studentService;

    // ------------------ VInh start -----------------------------------
    @GetMapping("/find-by-student/{studentId}")
    public ResponseEntity<?> findByStudentId(@PathVariable Long studentId) {
        ThesisDetail thesisDetail = new ThesisDetail();
        Student student = this.studentService.findStudentById(studentId);
        if (student.getStudentGroup() != null) {
            if (student.getStudentGroup().getCheckThesis() != null) {
                thesisDetail.setCheckThesis(student.getStudentGroup().getCheckThesis());
            }
        }
        return ResponseEntity.ok(thesisDetail);
    }

    // ------------------ VInh start -----------------------------

    @Autowired
    public CheckThesisService checkThesisService;

    @Autowired
    private TeacherService teacherService;

    List<CheckThesisDTODabh> checkThesisList;


    /*List check thesis unapproved*/
    @RequestMapping(value = "list-check-thesis/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCheckThesis(@PathVariable Long id) {
        Long idTeacher = this.teacherService.getIdTeacher(id);
        checkThesisList = this.checkThesisService.getAllCheckThesis(idTeacher);
        return new ResponseEntity<>(checkThesisList, HttpStatus.OK);
    }

    /*List check thesis approved*/
    @RequestMapping(value = "list-check-thesis-approved/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCheckThesisApproved(@PathVariable Long id) {
        Long idTeacher = this.teacherService.getIdTeacher(id);
        List<CheckThesisDTODabh> checkThesisListApproved = this.checkThesisService.getAllCheckThesisApproved(idTeacher);
        return new ResponseEntity<>(checkThesisListApproved, HttpStatus.OK);
    }

    /*Save check thesis*/
    @RequestMapping(value = "save-check-thesis/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveAllCheckThesis(@PathVariable Long id) {
        LocalDateTime dateNow = LocalDateTime.now();
        this.checkThesisService.saveCheckThesis(dateNow, id);
        return ResponseEntity.ok(new MessageDTO("Save check thesis successfully"));
    }

    /*Display list delete thesis unapproved*/
    @RequestMapping(value = "load-list-delete-check-thesis/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> loadListDeleteCheckThesis(@PathVariable Long id) {
        Long idTeacher = this.teacherService.getIdTeacher(id);
        List<CheckThesis> loadListDeleteCheckThesis = this.checkThesisService.loadListDeleteCheckThesis(idTeacher);
        return new ResponseEntity<>(loadListDeleteCheckThesis, HttpStatus.OK);
    }

    /*Update check thesis*/
    @RequestMapping(value = "update-check-thesis/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateCheckThesis(@PathVariable Long id) {
        this.checkThesisService.saveUpdateCheckThesis(id);
        return ResponseEntity.ok(new MessageDTO("Update check thesis successfully"));
    }


    /*Delete list check thesis unapproved*/
    @RequestMapping(value = "delete-check-thesis/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteCheckThesis(@PathVariable Long id) {
        this.checkThesisService.deleteCheckThesisUnApproved(id);
        return ResponseEntity.ok(new MessageDTO("Delete successfully"));
    }

}
