package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.entity.Interaction;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.repository.InteractionRepository;
import com.sprint3.backend.repository.NotificationRepository;
import com.sprint3.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {
    // Din Start
    @Autowired
    AppAccountRepository appAccountRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    InteractionRepository interactionRepository;

    @Override
    public void createNotification(Long idInteraction, Long accountStudent) {
        Student student = this.appAccountRepository.findById(accountStudent).orElse(null).getStudent();
        AppAccount accountTeacher = student.getStudentGroup().getTeacher().getAppAccount();
        Interaction interaction = this.interactionRepository.searchById(idInteraction);
        LocalDateTime localDateTime = LocalDateTime.now();
        this.notificationRepository.createNotification(student.getFullName()+
                        " đã gửi phản hồi cho bạn về chủ đề \"" + interaction.getTitle() +"\"",
                localDateTime,"aaaaa", false, accountTeacher.getId());
    }

    // Din End
}
