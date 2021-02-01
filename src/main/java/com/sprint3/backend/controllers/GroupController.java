package com.sprint3.backend.controllers;

import com.sprint3.backend.converter.StudentGroupConverter;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.GroupStudentDTOQuoc;
import com.sprint3.backend.services.StudentGroupService;
import com.sprint3.backend.services.StudentService;
import com.sprint3.backend.services.TeacherService;
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
    @Autowired
    TeacherService teacherService;

    /**
     * quoc controller create new group
     * @param groupStudentDTOQuoc
     * @return int
     */
    @PostMapping("/createNew/{idTeacher}")
    public int addNewGroup(@RequestBody GroupStudentDTOQuoc groupStudentDTOQuoc,@PathVariable("idTeacher") Long id) {
        try {
            List<Student> students = groupStudentDTOQuoc.getStudents();
            Teacher teacher = this.teacherService.findTeacherById(id);
            Long idStudentLeader  =  groupStudentDTOQuoc.getLeaderGroupId();
            StudentGroup studentGroup = new StudentGroup();
            Long quantity = Long.valueOf(students.size());
            studentGroup.setQuantity(quantity);
            studentGroup.setTeacher(teacher);
            String groupName = groupStudentDTOQuoc.getGroupName();
            studentGroup.setGroupName(groupName);;
            this.studentGroupService.save(studentGroup);
            for (int i = 0; i < students.size() ; i++) {
                    students.get(i).setStudentGroup(studentGroup);
                    students.get(i).setPosition(false);
                    this.studentService.save(students.get(i));
            }
            Student studentLeader = this.studentService.findById(idStudentLeader);
            studentLeader.setPosition(true);
            this.studentService.save(studentLeader);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //end quoc tạo group
}
