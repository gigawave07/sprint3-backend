package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.ThesisDetail;
import com.sprint3.backend.repository.ThesisDetailRepository;
import com.sprint3.backend.services.ThesisDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesisDetailServiceImpl implements ThesisDetailService {

    @Autowired
    private ThesisDetailRepository thesisDetailRepository;

    // ------------------------ Vinh start ----------------------------------
    @Override
    public void save(ThesisDetail thesisDetail) {
        this.thesisDetailRepository.save(thesisDetail);
    }

    @Override
    public List<ThesisDetail> findAllByCheckThesisId(Long checkThesisId) {
        return this.thesisDetailRepository.findAllByCheckThesisId(checkThesisId);
    }
    // ------------------------ Vinh start ----------------------------------
}
