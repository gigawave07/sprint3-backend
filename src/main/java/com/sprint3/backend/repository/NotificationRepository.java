package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Notification;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Modifying
    @Query(value = "INSERT INTO notification(content, create_date, noti_url,status,app_account_id) value(?1, ?2, ?3, ?4, ?5) ", nativeQuery = true)
    void createNotification(String content, LocalDateTime create_date, String noti_url, Boolean status, Long app_account_id);
}
