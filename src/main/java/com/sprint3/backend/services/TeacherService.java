package com.sprint3.backend.services;

import com.sprint3.backend.entity.Teacher;

public interface TeacherService {
    /**
     * quoc sử dụng
     * @param id
     * @return Teacher
     */
    Teacher findTeacherById(Long id);
}
