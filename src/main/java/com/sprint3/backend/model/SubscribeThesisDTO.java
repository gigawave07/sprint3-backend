package com.sprint3.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeThesisDTO {
    Long idStudent;
    String statement;
    Long amount;
    String description;
}
