package com.sprint3.backend.services;

import com.sprint3.backend.entity.Teacher;

public interface TeacherService {
    /**
     * Lành start
     * @param id
     * @return teacher
     */
    Teacher findByTeacherId(Long id);

    /**
     * lành end
     */
}
