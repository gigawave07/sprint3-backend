package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.services.AppAccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppAccountServiceImpl implements AppAccountService {
    @Autowired
    private AppAccountRepository appAccountRepository;
    @Override
    public AppAccount findAccountByUserName(String username) {
        return this.appAccountRepository.findAccountByUserName(username);
    }
}
