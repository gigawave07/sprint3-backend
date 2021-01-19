package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint2.backend.entity.AppAdmin;

@Repository
public interface AppAdminRepository extends JpaRepository<AppAdmin, Long> {
}
