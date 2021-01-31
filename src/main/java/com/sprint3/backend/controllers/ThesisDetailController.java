package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.DTO.ThesisDetailDTO;
import com.sprint3.backend.entity.DTO.ThesisDetailVinhDTO;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.services.CheckThesisService;
import com.sprint3.backend.services.StudentService;
import com.sprint3.backend.services.ThesisDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/thesis-detail")
@CrossOrigin
public class ThesisDetailController {
    @Autowired
    private ThesisDetailService thesisDetailService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CheckThesisService checkThesisService;
    // ---------------------- Vinh start -----------------------------

    @GetMapping("/check-thesis-detail/{studentId}")
    public ResponseEntity<?> checkThesisDetail(@PathVariable Long studentId) {
        ThesisDetailVinhDTO thesisDetailVinhDTO = new ThesisDetailVinhDTO();
        Student student = this.studentService.findStudentById(studentId);
        CheckThesis checkThesis = null;
        if (student.getStudentGroup() != null) {
            if (student.getStudentGroup().getCheckThesis() != null) {
                checkThesis = student.getStudentGroup().getCheckThesis();
            }
        }
        List<ThesisDetail> thesisDetailList;
        ThesisDetail thesisDetail;
        thesisDetailList = this.thesisDetailService.findAllByCheckThesisId(checkThesis.getId());
        if (thesisDetailList.size() != 0) {
            thesisDetail = thesisDetailList.get(thesisDetailList.size() - 1);
            if (thesisDetail.getFirstComment() == null) {
                thesisDetailVinhDTO.setId(thesisDetail.getId());
                thesisDetailVinhDTO.setMessage("not first comment");
                thesisDetailVinhDTO.setCheckThesisId(checkThesis.getId());
            } else if (thesisDetail.getSecondComment() == null) {
                thesisDetailVinhDTO.setId(thesisDetail.getId());
                thesisDetailVinhDTO.setMessage("not second comment");
                thesisDetailVinhDTO.setCheckThesisId(checkThesis.getId());
            } else {
                thesisDetailVinhDTO.setMessage("full comment");
                thesisDetailVinhDTO.setCheckThesisId(checkThesis.getId());
            }
        } else {
            thesisDetailVinhDTO.setMessage("not exits");
            thesisDetailVinhDTO.setCheckThesisId(checkThesis.getId());
        }
        return ResponseEntity.ok(thesisDetailVinhDTO);
    }

    @PostMapping("/upload-thesis-detain")
    public ResponseEntity<?> upload(@RequestBody ThesisDetailVinhDTO thesisDetailVinhDTO) {
        ThesisDetail thesisDetail = new ThesisDetail();
        if (thesisDetailVinhDTO.getId() != null) {
            thesisDetail = this.thesisDetailService.findById(thesisDetailVinhDTO.getId());
            thesisDetail.setId(thesisDetailVinhDTO.getId());
            if (thesisDetailVinhDTO.getCheckReport().equals("not first comment")) {
                thesisDetail.setFirstFileUrl(thesisDetailVinhDTO.getFileUrl());
                thesisDetail.setFirstDescription(thesisDetailVinhDTO.getDescription());
                thesisDetail.setFirstProgressFile(thesisDetailVinhDTO.getProgressFile());
                thesisDetail.setFirstSubmitDate(LocalDateTime.now());
            } else if (thesisDetailVinhDTO.getCheckReport().equals("not second comment")) {
                thesisDetail.setSecondFileUrl(thesisDetailVinhDTO.getFileUrl());
                thesisDetail.setSecondDescription(thesisDetailVinhDTO.getDescription());
                thesisDetail.setSecondProgressFile(thesisDetailVinhDTO.getProgressFile());
                thesisDetail.setSecondSubmitDate(LocalDateTime.now());
            }
        } else {
            thesisDetail.setFirstFileUrl(thesisDetailVinhDTO.getFileUrl());
            thesisDetail.setFirstProgressFile(thesisDetailVinhDTO.getProgressFile());
            thesisDetail.setFirstSubmitDate(LocalDateTime.now());
            thesisDetail.setCheckThesis(this.checkThesisService.findById(thesisDetailVinhDTO.getCheckThesisId()));

        }
        this.thesisDetailService.save(thesisDetail);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/get-thesis-detail-list")
    public ResponseEntity<?> getList() {
        List<ThesisDetail> thesisDetailList;
        thesisDetailList = this.thesisDetailService.findAll();
        List<ThesisDetailDTO> thesisDetailDTOList = new ArrayList<>();
        ThesisDetailDTO thesisDetailDTO = new ThesisDetailDTO();
        for (ThesisDetail thesisDetail : thesisDetailList) {
            thesisDetailDTO.setId(thesisDetail.getId());
            thesisDetailDTO.setGroupName(thesisDetail.getCheckThesis().getStudentGroup().getGroupName());
            thesisDetailDTO.setThesisName(thesisDetail.getCheckThesis().getThesis().getStatement());
            thesisDetailDTO.setFirstSubmitDate(thesisDetail.getFirstSubmitDate());
            thesisDetailDTO.setFirstComment(thesisDetail.getFirstComment());
            thesisDetailDTO.setSecondSubmitDate(thesisDetail.getSecondSubmitDate());
            thesisDetailDTO.setSecondComment(thesisDetail.getSecondComment());
            thesisDetailDTO.setFirstFileUrl(thesisDetail.getFirstFileUrl());
            thesisDetailDTO.setSecondFileUrl(thesisDetail.getSecondFileUrl());
            thesisDetailDTOList.add(thesisDetailDTO);
        }
        return ResponseEntity.ok(thesisDetailDTOList);
    }

    // ---------------------- Vinh end -----------------------------
}
