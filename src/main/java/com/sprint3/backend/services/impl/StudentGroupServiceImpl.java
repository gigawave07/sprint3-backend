package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.model.StudentGroupDTO;
import com.sprint3.backend.repository.CheckThesisRepository;
import com.sprint3.backend.repository.StudentGroupRepository;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    /**
     * Lành start
     */

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private CheckThesisRepository checkThesisRepository;

    @Override
    public List<StudentGroupDTO> findAll() {
        List<StudentGroupDTO> studentGroupDTOList = new ArrayList<>();
        List<StudentGroup> studentGroupList = this.studentGroupRepository.findAll();
        for (StudentGroup studentGroup : studentGroupList) {
            StudentGroupDTO studentGroupDTO = new StudentGroupDTO();
            studentGroupDTO.setId(studentGroup.getId());
            studentGroupDTO.setGroupName(studentGroup.getGroupName());
            studentGroupDTO.setQuantity(studentGroup.getQuantity());
            studentGroupDTOList.add(studentGroupDTO);
        }
        return studentGroupDTOList;
    }

    @Override
    public List<Student> findStudentGroup(Long id) {
        return this.studentRepository.getListStudentByGroupID(id);
    }


    @Override
    public void setNullStudent(Long id) {
        List<Student> studentList = this.findStudentGroup(id);
        StudentGroup studentGroup = this.findById(id);
        CheckThesis checkThesis = this.checkThesisRepository.findById(id).orElse(null);

        studentGroup.setTeacher(null);
        studentGroupRepository.save(studentGroup);

        if (checkThesis != null){
            studentGroup.getCheckThesis().setStudentGroup(null);
            studentGroupRepository.save(studentGroup);
        }

        for (Student student : studentList) {
            student.setStudentGroup(null);
            studentRepository.save(student);
        }

        studentGroupRepository.deleteById(id);
    }


    @Override
    public StudentGroup findById(Long id) {
        return this.studentGroupRepository.findById(id).orElse(null);
    }

    /**
     * Lành end
     */
}
