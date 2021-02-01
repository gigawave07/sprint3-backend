package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.TeacherRepository;
import com.sprint3.backend.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    /**
     * Quoc sử dụng để lấy thông tin giáo viên tạo nhóm
     */
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public Teacher findTeacherById(Long id) {
        return this.teacherRepository.findById(id).orElse(null);
    }
    // end quốc
}
