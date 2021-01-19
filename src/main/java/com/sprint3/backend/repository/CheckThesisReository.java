package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.CheckThesis;

@Repository
public interface CheckThesisReository extends JpaRepository<CheckThesis, Long> {
}
