package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.model.ChangePasswordUserDTO;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.services.AppAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
//    @Autowired
//    AppAccountService appAccountService;
//    @Autowired
//    PasswordEncoder bcryptEncoder;

//    nq.khanh start

//    @GetMapping("/find-account/{id}")
//    public ResponseEntity<?> findAccount(@PathVariable Long id) {
//        AppAccount appAccount = this.appAccountService.findAccountById(id);
//        return ResponseEntity.ok(appAccount);
//    }

//    @PutMapping("/check-passsword-user/{id}")
//    public Boolean checkPassword(@PathVariable Long id, @RequestBody ChangePasswordUserDTO changePasswordUserDTO
//    ) {
//        AppAccount appAccount = this.appAccountService.findAccountById(id);
//        boolean isMatch = bcryptEncoder.matches(changePasswordUserDTO.getPasswordOld(), appAccount.getPassword());
//        if (isMatch) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @PutMapping("/change-password-user/{id}")
//    public ResponseEntity<?> chanePassword(@PathVariable Long id, @RequestBody ChangePasswordUserDTO changePasswordUserDTO) {
//        this.appAccountService.changePasswordUser(bcryptEncoder.encode(changePasswordUserDTO.getPasswordNew()), id);
//        return ResponseEntity.ok(new MessageDTO("change password successfully"));
//    }
}
