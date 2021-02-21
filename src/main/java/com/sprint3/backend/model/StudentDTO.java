package com.sprint3.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String fullName;
    private String studentCode;
    private String email;
    private String phone;
    private Boolean position = false;
    private String teacher;
    private String topic;
}
