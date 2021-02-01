package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AppAccountRepository appAccountRepository;

    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return this.teacherRepository.findById(id).orElse(null );
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = this.teacherRepository.findById(id).orElse(null);
        AppAccount appAccount = teacher.getAppAccount();
        this.appAccountRepository.delete(appAccount);
    }
}
