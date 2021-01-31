package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.services.AppAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppAccountServiceImpl implements AppAccountService {
    @Autowired
    private AppAccountRepository appAccountRepository;
    @Override
    public AppAccount findAccountByUserName(String username) {
        return this.appAccountRepository.findAccountByUserName(username);
    }

    @Override
    public AppAccount findAccountById(Long id) {
        return this.appAccountRepository.findAccountById(id);
    }

    @Override
    public void changePasswordUser(String password, Long id) {
        this.appAccountRepository.changePasswordUser(password,id);
    }
}
