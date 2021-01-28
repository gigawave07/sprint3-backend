package com.sprint3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.ThesisDetail;

import java.util.List;

@Repository
public interface ThesisDetailRepository extends JpaRepository<ThesisDetail, Long> {
//    ----------------------------------- Vinh start --------------------------------------
    @Query(value = "select * from thesis_detail where check_thesis_id = :checkThesisId", nativeQuery = true)
    List<ThesisDetail> findAllByCheckThesisId(@Param("checkThesisId") Long checkThesisId);
}
//    ----------------------------------- Vinh end --------------------------------------
