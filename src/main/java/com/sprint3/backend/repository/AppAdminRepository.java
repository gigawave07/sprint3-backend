package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.AppAdmin;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppAdminRepository extends JpaRepository<AppAdmin, Long> {
    @Modifying
    @Query(value = "update app_admin set full_name=?1, mail=?2, address=?3 where id=?4", nativeQuery = true)
    void updateAdminInfo(String fullName, String email, String address, Long id);
}
