package com.sprint3.backend.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint3.backend.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Quoc Sử Dụng
 */
public class GroupStudentDTOQuoc {
    private String groupName;
    private Long leaderGroupId;
    private List<Student> students;
}
