package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.StudentGroupDTO;
import com.sprint3.backend.services.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupController {

    /**
     * Lành start
     */

    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentGroupDTO>> getAll(){
        List<StudentGroupDTO> studentGroupDTOList = this.studentGroupService.findAll();
        return ResponseEntity.ok(studentGroupDTOList);
    }

    @GetMapping("/infoStudent/{id}")
    public ResponseEntity<List<Student>> getStudentGroup(@PathVariable Long id){
        List<Student> studentList = this.studentGroupService.findStudentGroup(id);
        return ResponseEntity.ok(studentList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteGroup(@PathVariable Long id){
        MessageDTO messageDTO = this.studentGroupService.setNullStudent(id);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @GetMapping("/findBy/{id}")
    public ResponseEntity<StudentGroup> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(studentGroupService.findById(id));
    }


    /**
     * Lành end
     */
}
