package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.FeedBackDTO;
import com.sprint3.backend.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/7")
public class FeedbackController {
    @Autowired
    private FeedBackService feedBackService;

    @GetMapping("/{idAppAccount}")
    public ResponseEntity<List<FeedBackDTO>> getListStudent(@PathVariable Long idAppAccount){
        List<Student> studentList = this.feedBackService.getListStudentByAppAccountID(idAppAccount);
        List<Interaction> interactionList = this.feedBackService.getAllFeedBackFromStudent(studentList);
        if (interactionList != null){
            List<FeedBackDTO> feedBackDTOList = this.feedBackService.convertToListFeedBackDTO(interactionList);
            return new ResponseEntity<>(feedBackDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/infoQuestion/{idQuestion}")
    public ResponseEntity<FeedBackDTO> getInfoQuestion(@PathVariable Long idQuestion){
        return new ResponseEntity<>(this.feedBackService.getFeedBackDTOByID(idQuestion),HttpStatus.OK);
    }

    @DeleteMapping("/infoQuestion/{idQuestion}")
    public ResponseEntity<FeedBackDTO> deleteQuestion(@PathVariable Long idQuestion){
        this.feedBackService.deleteInteractionByID(idQuestion);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
