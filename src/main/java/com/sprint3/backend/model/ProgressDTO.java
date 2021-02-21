package com.sprint3.backend.model;

import java.time.LocalDateTime;
import java.util.Date;

public interface ProgressDTO {
    String getNameThesis();
    String getComment();
    Long getStatus();
    Long getMark();
    Date getDateSubmit();
}
