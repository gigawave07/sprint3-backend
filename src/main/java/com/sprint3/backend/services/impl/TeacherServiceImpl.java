package com.sprint3.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.repository.AppRoleRepository;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppAccountRepository appAccountRepository;

    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        try {
            this.teacherRepository.save(teacher);
            AppAccount appAccount = new AppAccount();
            appAccount.setAppRole(this.appRoleRepository.findById((long) 1).orElse(null));
            appAccount.setUsername(teacher.getTeacherCode());
            appAccount.setPassword("123");
            appAccount.setEnabled(true);
            this.appAccountRepository.save(appAccount);
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }

    }

    @Override
    public List<Teacher> search(String input, String key, Pageable pageable) {
        switch (input) {
            case "fullName":
                return teacherRepository.getTeachersByName(key);
            case "teacherCode":
                return teacherRepository.getTeachersByTeacherCode(key);
            case "email":
                return teacherRepository.getTeachersByEmail(key);
            case "identityNumber":
                return teacherRepository.getTeachersByIdNumber(key);
            case "phone":
                return teacherRepository.getTeachersByPhone(key);
        }
        return null;
    }
}
