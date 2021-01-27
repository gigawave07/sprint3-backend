package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Teacher;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.repository.InteractionRepository;
import com.sprint3.backend.repository.NotificationRepository;
import com.sprint3.backend.services.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InteractionServiceImpl implements InteractionService {
    // Din
    @Autowired
    InteractionRepository interactionRepository;
    @Autowired
    AppAccountRepository appAccountRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public void createInteraction(String content, String title, Long accountStudent) {
        Student student = this.appAccountRepository.findById(accountStudent).orElse(null).getStudent();
        AppAccount accountTeacher = student.getStudentGroup().getTeacher().getAppAccount();
        this.interactionRepository.createInteraction(content, title, student.getId());
        LocalDateTime localDateTime = LocalDateTime.now();
        this.notificationRepository.createNotification(student.getFullName()+" đã gửi phản hồi cho bạn về chủ đề \"" + title +"\"",
                localDateTime,"aaaaa", false, accountTeacher.getId());
    }

    public Page<Interaction> getAll(int pageable, Long accountStudent, Optional<String> search) {
        Student student = this.appAccountRepository.findById(accountStudent).orElse(null).getStudent();
        Pageable pageable1 = PageRequest.of(pageable, 5);
        if (search.isPresent()){
            return this.interactionRepository.searchByTitle(student.getId(),search.get(), pageable1);
        }
        return this.interactionRepository.getAll(student.getId(), pageable1);
    }

    @Override
    public void deleteById(Long idInteraction) {
        this.interactionRepository.deleteById(idInteraction);
    }

    @Override
    public Interaction searchById(Long idInteraction) {
        return this.interactionRepository.searchById(idInteraction);
    }


    // Din End
}
