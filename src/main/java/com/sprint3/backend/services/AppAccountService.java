package com.sprint3.backend.services;

import com.sprint3.backend.entity.AppAccount;

public interface AppAccountService {
    AppAccount findAccountByUserName(String username);
}
