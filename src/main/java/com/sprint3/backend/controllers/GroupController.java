package com.sprint3.backend.controllers;

import com.sprint3.backend.model.StudentGroupDTO;
import com.sprint3.backend.services.StudentGroupService;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupController {

    @Autowired
    private StudentGroupService studentGroupService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list-student-group/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StudentGroupDTO>> getAllStudentGroup(@PathVariable String id) {
        List<StudentGroupDTO> studentGroupList = this.studentGroupService.findAllStudentGroup(id);
//        List<StudentDTO> students = null;
//        for (int i = 0; i < studentGroupList.size(); i++) {
//            students = this.studentService.getAllStudent(studentGroupList.get(i).getIdStudentGroup());
//        }
//        return new ResponseEntity<>(students, HttpStatus.OK);
        return new ResponseEntity<>(studentGroupList, HttpStatus.OK);
    }
}
