package com.sprint3.backend.services;

import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.model.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ThesisService {

    /**
     * Lành start
     */

    Page<Thesis> findAll(int page);

    void createNewThesis(Thesis thesis);

    void updateThesis(Thesis thesis); 

    MessageDTO deleteByID(Long id);

    Thesis findById(Long id);

    Specification<Thesis> getFilter(String statement, String amount);

    Page<Thesis> findThesisByCriteria(Specification<Thesis> spec, int page);

    List<Thesis> findAllThesis();


    /**
     * Lành end
     */
}
