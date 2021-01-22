package com.sprint3.backend.services.impl;


import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.repository.ThesisRepository;
import com.sprint3.backend.services.ThesisService;
import com.sprint3.backend.services.search.SearchCriteria;
import com.sprint3.backend.services.search.ThesisSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThesisServiceImpl implements ThesisService {
    @Autowired
    ThesisRepository thesisRepository;

    /**
     *Lành start
     */

    @Override
    public Page<Thesis> findAll(int page) {
        Pageable pageable = PageRequest.of(page - 1, 4, Sort.by("id"));
        Page<Thesis> thesisPage = thesisRepository.findAll(pageable);
        return thesisPage;
    }

    @Override
    public void createNewThesis(Thesis thesis) {
        this.thesisRepository.save(thesis);
    }

    @Override
    public void updateThesis(Thesis thesis) {
        this.thesisRepository.save(thesis);
    }

    @Override
    public void deleteByID(Long id) {
        this.thesisRepository.deleteById(id);
    }

    @Override
    public Thesis findById(Long id) {
        return thesisRepository.findById(id).orElse(null);
    }

    @Override
    public Specification<Thesis> getFilter(String statement, String amount) {
        List<ThesisSpecification> specs = new ArrayList<>();
        Specification<Thesis> spec;
        // search theo name
        if (!"".equals(statement) && !"undefined".equals(statement)) {
            specs.add(new ThesisSpecification(new SearchCriteria("statement", "like", statement)));
        }
        // search theo so luong sinh vien
        if (!"".equals(amount) && !"undefined".equals(amount)) {
            specs.add(new ThesisSpecification(new SearchCriteria("amount", "like", amount)));
        }
        if (specs.size() != 0) {
            spec = Specification.where(specs.get(0));
            for (int i = 1; i < specs.size(); i++) {
                assert spec != null;
                spec = spec.and(specs.get(i));
            }
            return spec;
        }
        return null;
    }

    @Override
    public Page<Thesis> findThesisByCriteria(Specification<Thesis> spec, int page) {
        Pageable pageable = PageRequest.of(page - 1, 4);
        Page<Thesis> thesisPage = thesisRepository.findAll(spec, pageable);
        return thesisPage;
    }

    @Override
    public List<Thesis> findAllThesis() {
        return thesisRepository.findAll();
    }

    /**
     * Lành end
     */
}
