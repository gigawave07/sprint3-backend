package com.sprint3.backend.services;

import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.model.FeedBackDTO;

import java.util.List;

public interface FeedBackService {
    List<Student> getListStudentByAppAccountID(Long idTeacher);
    List<Interaction> getAllFeedBackFromStudent(List<Student> studentList);
    FeedBackDTO convertToFeedBackDTO(Interaction interaction);
    List<FeedBackDTO> convertToListFeedBackDTO(List<Interaction> interactionList);
    FeedBackDTO getFeedBackDTOByID(Long idInteraction);
    void deleteInteractionByID(Long idInteraction);
}
