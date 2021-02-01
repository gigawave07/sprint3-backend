package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.StudentDTO;
import com.sprint3.backend.services.AppAccountService;
import com.sprint3.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AppAccountService appAccountService;


    // Create by: Đạt _ Get List Student
    @GetMapping("/list")
    public ResponseEntity<List<Student>> getListStudent() {
        List<Student> listStudent = this.studentService.findAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }
    // Create by: Đạt _ Add new Student
    @PostMapping("/addNew")
    public ResponseEntity<StudentDTO> AddNewStudent(@RequestBody StudentDTO studentDTO) {
        this.studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Create by: Đạt _  Search Student
    @GetMapping("/inputSearch")
    public ResponseEntity<List<Student>> searchStudent(@RequestParam("valueSearch") String inputSearch) {
        List<Student> studentList = studentService.searchStudent(inputSearch);
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    // Hoàng begin
    @GetMapping("/prepareDeleteStudent/{id}")
    public ResponseEntity<?> PrepareDeleteStudent(@PathVariable Long id) {
        Student student = studentService.findByID(id);
        student.setStudentGroup(null);
        if (student.getAppAccount() != null) {
            student.getAppAccount().setAppRole(null);
        }
        student.setAppAccount(null);
        this.studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete student by id
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
//        this.appAccountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //edit student
    @PutMapping("/editStudent/{id}")
    public ResponseEntity<List<Student>> editStudent(@RequestBody StudentDTO studentDTO, @PathVariable long id) {
        Student student = studentService.findByID(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            student.setStudentCode(studentDTO.getStudentCode().trim());
            student.setFullName(studentDTO.getFullName().trim());
            student.setTeacher(studentDTO.getTeacher());
            student.setEmail(studentDTO.getEmail().trim());
            student.setPhone(studentDTO.getPhone().trim());
            student.setTopic(studentDTO.getTopic());
            this.studentService.editStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //get student by id
    @GetMapping("/findStudentById/{id}")
    public ResponseEntity<?> findStudent(@PathVariable long id) {
        Student student = studentService.findByID(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    //Hoàng end

    /**
     * Quoc Controller
     * search Student no group
     */
    @GetMapping("/studentNoGroup")
    public List<Student> getAllStudentNoGroup(
            @RequestParam String by,
            @RequestParam String search) {
        List<Student> students = this.studentService.search(search, by);
        return students;
    }

    /**
     * Quoc Controller
     * @return studentListNoGr
     */
    @GetMapping("/listAllStudentNoGroup")
    public List<Student> getAllStudentNoGr(){
        try {
            List<Student> studentList = this.studentService.findAllStudentNoGroup();
            return studentList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Quoc Controller
     * getStudent by id
     *
     */
    @GetMapping("/studentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long id) {
        return this.studentService.findById(id);
    }
    // end quoc
}
