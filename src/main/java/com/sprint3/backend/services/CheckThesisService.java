package com.sprint3.backend.services;

import com.sprint3.backend.entity.CheckThesis;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.CheckThesisDTODabh;
import com.sprint3.backend.model.CheckThesisDTO;
import com.sprint3.backend.model.SaveCheckThesisDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckThesisService {
    void save(CheckThesis checkThesis);

    CheckThesis findById(Long id);

    /*List check thesis unapproved*/
    List<CheckThesisDTODabh> getAllCheckThesis(Long idTeacher);

    /*List check thesis approved*/
    List<CheckThesisDTODabh> getAllCheckThesisApproved(Long idTeacher);

    /*Save check thesis*/
    void saveCheckThesis(LocalDateTime checkDate, Long idCheckThesis);

    /*Display list delete thesis unapproved*/
    List<CheckThesis> loadListDeleteCheckThesis(Long idTeacherParam);

    /*Update check thesis*/
    void saveUpdateCheckThesis(Long idParam);

    /*Delete list check thesis unapproved*/
    void deleteCheckThesisUnApproved(Long idCheckThesis);


}
