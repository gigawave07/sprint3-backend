package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.DTO.MessageDTO;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.services.StudentService;
import com.sprint3.backend.services.ThesisDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thesis-detail")
@CrossOrigin
public class ThesisDetailController {
    @Autowired
    private ThesisDetailService thesisDetailService;

    @Autowired
    private StudentService studentService;
    // ---------------------- Vinh start -----------------------------

    @GetMapping("/check-thesis-detail/{studentId}")
    public ResponseEntity<?> checkThesisDetail(@PathVariable Long studentId) {
        MessageDTO messageDTO = new MessageDTO("");
        Student student = this.studentService.findStudentById(studentId);
        CheckThesis checkThesis = null;
        if (student.getStudentGroup() != null) {
            if (student.getStudentGroup().getCheckThesis() != null) {
                checkThesis = student.getStudentGroup().getCheckThesis();
            }
        }
        List<ThesisDetail> thesisDetailList;
        ThesisDetail thesisDetail = new ThesisDetail();
        thesisDetailList = this.thesisDetailService.findAllByCheckThesisId(checkThesis.getId());
        if (thesisDetailList.size() != 0) {
            thesisDetail = thesisDetailList.get(thesisDetailList.size() - 1);
            if (thesisDetail.getFirstComment() == null) {
                messageDTO.setMessage("not first comment");
            } else if (thesisDetail.getSecondComment() == null) {
                messageDTO.setMessage("not second comment");
            } else {
                messageDTO.setMessage("full comment");
            }
        } else {
            messageDTO.setMessage("not exits");
        }
        return ResponseEntity.ok(messageDTO);
    }

    // ---------------------- Vinh end -----------------------------
}
