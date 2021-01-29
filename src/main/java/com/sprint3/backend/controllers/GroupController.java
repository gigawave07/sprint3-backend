package com.sprint3.backend.controllers;

import com.sprint3.backend.converter.StudentGroupConverter;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.model.GroupStudentDTOQuoc;
import com.sprint3.backend.services.StudentGroupService;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupController {
    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    StudentGroupConverter studentGroupConverter;
    @Autowired
    StudentService studentService;

    @PostMapping("/createNew")
    public int addNewGroup(@RequestBody GroupStudentDTOQuoc groupStudentDTOQuoc) {
        try {
            StudentGroup studentGroup = new StudentGroup();
            List<Student> students = groupStudentDTOQuoc.getStudents();
            Long quantity = Long.valueOf(students.size());
            studentGroup.setQuantity(quantity);
            String groupName = groupStudentDTOQuoc.getGroupName();
            studentGroup.setGroupName(groupName);;
            this.studentGroupService.save(studentGroup);
            for (int i = 0; i < students.size() ; i++) {
                students.get(i).setStudentGroup(studentGroup);
                this.studentService.save(students.get(i));
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
