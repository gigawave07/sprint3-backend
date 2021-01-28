package com.sprint3.backend.services;

import java.util.List;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.model.SubscribeThesisDTO;

public interface SubscribeThesisService {
    Student findStudentById(Long idStudent);

    List<CheckThesis> findAllCheckThesisForMail();

    List<Thesis> findAllThesisUnSubscribed(Long idStudent);

    List<CheckThesis> findAllThesisSubscribed(Long idStudent);

    Thesis findThesisById(Long idThesis);

    MessageDTO subscribeThesisOfTeacher(Long idThesis, Long idStudent);

    MessageDTO unsubscribeThesis(Long idCheckThesis);

    MessageDTO createThesis(Long idStudent, SubscribeThesisDTO subscribeThesisDTO);
}
