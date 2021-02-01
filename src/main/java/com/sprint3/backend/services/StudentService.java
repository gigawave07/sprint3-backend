package com.sprint3.backend.services;

import com.sprint3.backend.entity.Student;

public interface StudentService {
    // ---------------------- VInh start ---------------------------
    Student findStudentById(Long studentId);

    Student findStudentByAccountId(Long accountId);

    // ---------------------- VInh start ---------------------------
}
