package com.sprint3.backend.services;

import java.util.List;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.SubscribeThesisDTO;

public interface SubscribeThesisService {
    List<CheckThesis> findAllCheckThesisForMail();

    List<Thesis> findAllThesisByIdTeacher(Long idStudent);

    Thesis findThesisById(Long idThesis);

    void saveCheckThesis(SubscribeThesisDTO subscribeThesisDTO);
}
