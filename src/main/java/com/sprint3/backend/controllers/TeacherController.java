package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.TeacherDTO;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editUser(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            teacher.setFullName(teacherDTO.getFullName().trim());
            teacher.setTeacherCode(teacherDTO.getTeacherCode().trim());
            teacher.setEmail(teacherDTO.getEmail().trim());
            teacher.setPhone(teacherDTO.getPhone().trim());
            teacherService.save(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteEmployeeById(@PathVariable Long id) {
        Teacher teacher = this.teacherService.findById(id);
        teacher.getAppAccount().setAppRole(null);
        this.teacherService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
