package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.services.ThesisDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thesis-detail")
@CrossOrigin
public class ThesisDetailController {
    @Autowired
    private ThesisDetailService thesisDetailService;
    // ---------------------- Vinh start -----------------------------
//    @PostMapping("/upload-thesis-detail{id}")
//    public ResponseEntity<?> uploadThesisDetail(@RequestBody ThesisDetail thesisDetail, @PathVariable Long id){
//
//    }

    // ---------------------- Vinh end -----------------------------
}
