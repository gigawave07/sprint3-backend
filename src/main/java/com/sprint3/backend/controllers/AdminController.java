package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.AppAdmin;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.services.AppAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AppAdminService appAdminService;

    @PutMapping("/update-admin-info/{id}")
    public ResponseEntity<?> updateAdminInfo(@PathVariable Long id, @RequestBody AppAdmin adminDTO) {
        this.appAdminService.updateAdminInfo(adminDTO.getFullName(), adminDTO.getMail(), adminDTO.getAddress(), adminDTO.getId());
        return ResponseEntity.ok(new MessageDTO("update successfully"));
    }
}
