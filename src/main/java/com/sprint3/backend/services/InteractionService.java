package com.sprint3.backend.services;

import com.sprint3.backend.entity.Interaction;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface InteractionService {
    void createInteraction(String content,String title, Long accountStudent);
    Page<Interaction> getAll(int pageable, Long accountStudent, Optional<String> search);
    void deleteById(Long accountStudent);
    Interaction searchById(Long idInteraction);
}
