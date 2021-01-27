package com.sprint3.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.services.SubscribeThesisService;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.SubscribeThesisDTO;

@RestController
@RequestMapping("/subscribe-thesis")
@CrossOrigin
public class SubscribeThesisController {
    @Autowired
    private SubscribeThesisService subscribeThesisService;

    /*
     * find student currently logging
     * @param idStudent
     * @return ResponseEntity<Student>
     * */
    @GetMapping("/student/{idStudent}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long idStudent) {
        Student student = this.subscribeThesisService.findStudentById(idStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    /*
     * get all thesis unsubscribed of teacher
     * @param idStudent
     * @return ResponseEntity<List<Thesis>>
     * */
    @GetMapping("/thesis-unsubscribed/{idStudent}")
    public ResponseEntity<List<Thesis>> getListThesisUnSubscribed(@PathVariable Long idStudent) {
        List<Thesis> thesisList = this.subscribeThesisService.findAllThesisUnSubscribed(idStudent);
        return new ResponseEntity<>(thesisList, HttpStatus.OK);
    }

    /*
     * get all thesis subscribed of teacher
     * @param idStudent
     * @return ResponseEntity<List<Thesis>>
     * */
    @GetMapping("/thesis-subscribed/{idStudent}")
    public ResponseEntity<List<CheckThesis>> getListThesisSubscribed(@PathVariable Long idStudent) {
        List<CheckThesis> thesisList = this.subscribeThesisService.findAllThesisSubscribed(idStudent);
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

    /*
     * subscribe thesis of Teacher
     * @param idThesis, idStudent
     * @return MessageDTO
     * */
    @GetMapping("/thesis-teacher/{idThesis}/{idStudent}")
    public ResponseEntity<MessageDTO> subscribeThesisOfTeacher(@PathVariable Long idThesis,
                                                               @PathVariable Long idStudent) {
        MessageDTO messageDTO = this.subscribeThesisService.subscribeThesisOfTeacher(idThesis, idStudent);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    /*
     * unsubscribe thesis
     * @param idCheckThesis
     * @return MessageDTO
     * */
    @GetMapping("/unsubscribe-thesis/{idCheckThesis}")
    public ResponseEntity<MessageDTO> unsubscribeThesis(@PathVariable Long idCheckThesis) {
        MessageDTO messageDTO = this.subscribeThesisService.unsubscribeThesis(idCheckThesis);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    /*
     * create thesis
     * @param idStudent, subscribeThesisDTO
     * @return MessageDTO
     * */
    @PostMapping("/create/{idStudent}")
    public ResponseEntity<MessageDTO> createThesis(@PathVariable Long idStudent,
                                                   @RequestBody SubscribeThesisDTO subscribeThesisDTO) {
        MessageDTO messageDTO = this.subscribeThesisService.createThesis(idStudent, subscribeThesisDTO);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }
}
