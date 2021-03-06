package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Thesis;

import java.util.List;

@Repository
public interface ThesisRepository extends JpaRepository<Thesis, Long>, JpaSpecificationExecutor<Thesis> {
    List<Thesis> findByCheckThesis_Status(Boolean status);
}
