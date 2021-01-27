package com.sprint3.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Interaction;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    // Start Din
    @Modifying
    @Query(value = "INSERT INTO interaction(content, title, student_id) value(?1, ?2, ?3) ", nativeQuery = true)
    void createInteraction(String content,String title, Long studentId);

    @Query(value = "SELECT * FROM interaction WHERE student_id = ?1", nativeQuery = true)
    Page<Interaction> getAll(Long studentId,Pageable pageable);

    @Query(value = "SELECT * FROM interaction WHERE student_id = ?1 AND title LIKE %?2%", nativeQuery = true)
    Page<Interaction> searchByTitle(Long studentId,String search, Pageable pageable);

    @Query(value = "SELECT * FROM interaction WHERE id = ?1", nativeQuery = true)
    Interaction searchById(Long idInteraction);

    @Modifying
    @Query(value = "DELETE FROM interaction WHERE id = ?1", nativeQuery = true)
    void deleteById(Long idInteraction);
}
