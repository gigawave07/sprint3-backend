package com.sprint3.backend.services;

import com.sprint3.backend.entity.ThesisDetail;

import java.util.List;

public interface ThesisDetailService {
    void save(ThesisDetail thesisDetail);

    List<ThesisDetail> findAllByCheckThesisId(Long checkThesisId);

    List<ThesisDetail> findAll();

    ThesisDetail findById(Long id);
}
