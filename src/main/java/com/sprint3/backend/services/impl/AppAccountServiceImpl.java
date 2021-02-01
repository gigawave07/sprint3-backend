package com.sprint3.backend.services.impl;

import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.services.AppAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppAccountServiceImpl implements AppAccountService {
    @Autowired
    private AppAccountRepository appAccountRepository;
    @Override
    public void deleteById(Long id) {
        this.appAccountRepository.deleteById(id);
    }
}
