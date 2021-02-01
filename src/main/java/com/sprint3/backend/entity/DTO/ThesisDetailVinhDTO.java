package com.sprint3.backend.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDetailVinhDTO {
    Long id;
    Long checkThesisId;
    String thesisName;
    String groupName;
    String message;
    String progressFile;
    String fileUrl;
    String description;
    String percent;
    String checkReport;
}
