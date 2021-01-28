package com.sprint3.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupDTO {
    private Long id;
    private String groupName;
    private String studentCode;
    private String fullName;
    private String quantity;
}
