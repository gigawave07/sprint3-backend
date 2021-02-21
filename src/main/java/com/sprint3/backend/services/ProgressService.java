package com.sprint3.backend.services;

import com.sprint3.backend.model.ProgressDTO;

public interface ProgressService {
    public ProgressDTO getNameThesisByIdStudent(Long idStudent, Long progressThesis);
}
