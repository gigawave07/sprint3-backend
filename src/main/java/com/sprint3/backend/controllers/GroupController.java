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

    /**
     * Lành start
     */

    @Autowired
    private StudentGroupService studentGroupService;
    @Autowired
    StudentGroupConverter studentGroupConverter;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

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
            studentGroup.setQuantity(String.valueOf(quantity));
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

    /*List student*/
    @RequestMapping(value = "/list-student-group/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StudentDTO>> getAllStudentGroup(@PathVariable Long id) {
        Long idTeacher = this.teacherService.getIdTeacher(id);
        List<StudentGroupDTO> studentGroupList = this.studentGroupService.findAllStudentGroup(idTeacher);
        List<StudentDTO> students = new ArrayList<>();
        for (StudentGroupDTO studentGroupDTO : studentGroupList) {
            students.addAll(this.studentService.getAllStudent(studentGroupDTO.getIdStudentGroup()));
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
