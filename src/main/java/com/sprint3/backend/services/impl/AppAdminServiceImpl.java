package com.sprint3.backend.services.impl;

import com.sprint3.backend.repository.AppAdminRepository;
import com.sprint3.backend.services.AppAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppAdminServiceImpl implements AppAdminService {
    @Autowired
    AppAdminRepository appAdminRepository;
    @Override
    public void updateAdminInfo(String fullName, String email, String address, Long id) {
        this.appAdminRepository.updateAdminInfo(fullName,email,address,id);

    }
}
