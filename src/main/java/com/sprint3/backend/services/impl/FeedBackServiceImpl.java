package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.model.FeedBackDTO;
import com.sprint3.backend.repository.InteractionRepository;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InteractionRepository interactionRepository;

    @Override
    public List<Student> getListStudentByAppAccountID(Long idAccount) {
        return this.studentRepository.getListStudentByAppAccountID(idAccount);
    }

    @Override
    public List<Interaction> getAllFeedBackFromStudent(List<Student> studentList) {
        List<Interaction> interactionList = new ArrayList<>();
        for (Student student : studentList) {
            interactionList.addAll(student.getInteractionList());
        }
        return interactionList;
    }

    @Override
    public List<FeedBackDTO> convertToListFeedBackDTO(List<Interaction> Interaction) {
        List<FeedBackDTO> feedBackDTOList = new ArrayList<>();
        int idAutoIncrement = 1;
        for (Interaction interaction : Interaction) {
            FeedBackDTO feedBackDTO = this.convertToFeedBackDTO(interaction);
            feedBackDTO.setId(idAutoIncrement++);
            feedBackDTOList.add(feedBackDTO);
        }
        return feedBackDTOList;
    }

    @Override
    public FeedBackDTO convertToFeedBackDTO(Interaction interaction) {
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setTitle(interaction.getTitle());
        feedBackDTO.setContent(interaction.getContent());
        feedBackDTO.setStudentId(interaction.getStudent().getId());
        feedBackDTO.setStudentName(interaction.getStudent().getFullName());
        feedBackDTO.setInteractonId(interaction.getId());
        return feedBackDTO;
    }

    @Override
    public FeedBackDTO getFeedBackDTOByID(Long idInteraction) {
        Interaction interaction = this.interactionRepository.findById(idInteraction).orElse(null);
        if (interaction != null) {
            return this.convertToFeedBackDTO(interaction);
        }
        return null;
    }

    @Override
    public void deleteInteractionByID(Long idInteraction) {
        Interaction interaction = this.interactionRepository.findById(idInteraction).orElse(null);
        interaction.setStudent(null);
        this.interactionRepository.save(interaction);
        this.interactionRepository.deleteById(idInteraction);
    }
}
