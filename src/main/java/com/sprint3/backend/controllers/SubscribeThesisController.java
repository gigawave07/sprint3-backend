package com.sprint3.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.services.SubscribeThesisService;

@RestController
@RequestMapping("/subscribe")
@CrossOrigin
public class SubscribeThesisController {
    @Autowired
    private SubscribeThesisService subscribeThesisService;

    /*
     * get all thesis of teacher
     * @param idTeacher
     * @return ResponseEntity<List<Thesis>>
     * */
    @GetMapping("/list-thesis/{idStudent}")
    public ResponseEntity<List<Thesis>> getListThesisByIdStudent(@PathVariable Long idStudent) {
        List<Thesis> thesisList = this.subscribeThesisService.findAllThesisByIdTeacher(idStudent);
        return new ResponseEntity<>(thesisList, HttpStatus.OK);
    }

    /*
     * get thesis by id
     * @param idThesis
     * @return ResponseEntity<Thesis>
     * */
    @GetMapping("/thesis-detail/{idThesis}")
    public ResponseEntity<Thesis> getThesisById(@PathVariable Long idThesis) {
        Thesis thesis = this.subscribeThesisService.findThesisById(idThesis);
        return new ResponseEntity<>(thesis, HttpStatus.OK);
    }
}
