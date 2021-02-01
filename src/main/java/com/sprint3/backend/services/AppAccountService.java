package com.sprint3.backend.services;

import com.sprint3.backend.entity.AppAccount;
import org.springframework.stereotype.Service;

public interface AppAccountService {

    // ------------------ Hoang start -----------------------------
    void deleteById(Long id);
    // ------------------ Hoang start -----------------------------
    AppAccount findAccountByUserName(String username);
    AppAccount findAccountById(Long id);
    void changePasswordUser(String password, Long id);
}
