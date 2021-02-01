package com.sprint3.backend.converter;

import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.model.GroupStudentDTOQuoc;
import org.springframework.stereotype.Component;
/**
Quoc Sử dụng
 */
@Component
public class StudentGroupConverter {
    public StudentGroup toStudentGroup(GroupStudentDTOQuoc groupStudentDTOQuoc) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupName(groupStudentDTOQuoc.getGroupName());
        studentGroup.setStudentList(groupStudentDTOQuoc.getStudents());
        return studentGroup;
    }
    public GroupStudentDTOQuoc toStudentGroupDto(StudentGroup studentGroup){
        GroupStudentDTOQuoc groupStudentDTOQuoc = new GroupStudentDTOQuoc();
        groupStudentDTOQuoc.setGroupName(studentGroup.getGroupName());
        groupStudentDTOQuoc.setStudents(studentGroup.getStudentList());
        return groupStudentDTOQuoc;
    }
}
