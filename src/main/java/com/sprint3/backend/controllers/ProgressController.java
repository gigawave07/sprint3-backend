package com.sprint3.backend.controllers;

import com.sprint3.backend.model.ProgressDTO;
import com.sprint3.backend.services.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@CrossOrigin
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/progress/{idStudent}/{progressThesis}")
    public ResponseEntity<ProgressDTO> getInfoProgress(@PathVariable Long idStudent, @PathVariable Long progressThesis){
        System.out.println(progressThesis);
        return new ResponseEntity<ProgressDTO>(this.progressService.getNameThesisByIdStudent(idStudent,progressThesis), HttpStatus.OK);
    }

    @PostMapping("/progress/upload")
    public void getFileUpload(){
        System.out.println(123);
    }
}
