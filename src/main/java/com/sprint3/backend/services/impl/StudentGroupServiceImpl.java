package com.sprint3.backend.services.impl;

import com.sprint3.backend.converter.StudentGroupConverter;
import com.sprint3.backend.entity.StudentGroup;
import com.sprint3.backend.model.GroupStudentDTOQuoc;
import com.sprint3.backend.repository.StudentGroupRepository;
import com.sprint3.backend.services.StudentGroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    @Autowired
    StudentGroupRepository studentGroupRepository;
    @Autowired
    StudentGroupConverter studentGroupConverter;


    @Override
    public StudentGroup save(StudentGroup studentGroup) {
        return this.studentGroupRepository.save(studentGroup);
    }
}
