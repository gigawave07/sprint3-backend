package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.services.TeacherService;
import com.sprint3.backend.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thesis")
@CrossOrigin
public class ThesisController {
    // Create by: Đạt
    @Autowired
    private ThesisService thesisService;
    @GetMapping("/list2")
    public ResponseEntity<?> getListThesis() {
        List<Thesis> listThesis = this.thesisService.findAllThesis();
        return new ResponseEntity<>(listThesis, HttpStatus.OK);
    }
}
