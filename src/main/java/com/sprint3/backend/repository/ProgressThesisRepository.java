package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.ProgressThesis;

@Repository
public interface ProgressThesisRepository extends JpaRepository<ProgressThesis, Long> {
}
