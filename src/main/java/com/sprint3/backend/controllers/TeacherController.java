package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(allowedHeaders = "*",value = "*")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/getTeacher/{input}/{key}")
    public List<Teacher> getTeacher(
            @RequestParam(defaultValue = "0") int page,
            @PathVariable String key,
            @PathVariable String input) {
        Pageable pageable = PageRequest.of(page, 5);
        return teacherService.search(input,key, pageable);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teacherList = this.teacherService.findAll();
        return new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.OK);
    }
    @PostMapping("/addNewTeacher")
    public ResponseEntity<Void> addTeacher(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            teacherService.saveTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
    }
}
