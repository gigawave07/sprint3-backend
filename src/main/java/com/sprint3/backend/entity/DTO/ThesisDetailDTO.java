package com.sprint3.backend.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThesisDetailDTO {
    Long id;
    String groupName;
    String thesisName;
    LocalDateTime firstSubmitDate;
    String firstDescription;
    String firstFileUrl;
    String firstComment;
    LocalDateTime secondSubmitDate;
    String secondFileUrl;
    String secondDescription;
    String secondComment;
}
