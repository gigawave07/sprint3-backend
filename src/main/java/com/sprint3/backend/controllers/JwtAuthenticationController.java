package com.sprint3.backend.controllers;

import com.sprint3.backend.config.JwtTokenUtil;
import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.model.JwtRequest;
import com.sprint3.backend.model.JwtResponseNew;
import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.repository.AppAccountRepository;
import com.sprint3.backend.services.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    AppAccountRepository appAccountRepository;
//
//    @Autowired
//    private JwtUserDetailsService userDetailsService;
//
//    @GetMapping("/hello")
//    public ResponseEntity<?> hello() {
//        return ResponseEntity.ok(new MessageDTO("hello anh quan be de"));
//    }
//
//    // authenticate current user
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//        String username = authenticationRequest.getUsername();
//
//        // check username exist
//        if (appAccountRepository.findAccountByUserName(username) == null) {
//            return ResponseEntity.ok(new MessageDTO("Email chưa được đăng kí"));
//        }
//
////        // check if verification email is confirmed
////        if (!appAccountRepository.findAccountByUserName(username).getEnabled())
////            return ResponseEntity.ok(new MessageDTO("Email chưa được kích hoạt"));
//
//        authenticate(username, authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        AppAccount account = appAccountRepository.findAccountByUserName(username);
//        Long id = appAccountRepository.findAccountByUserName(username).getId();
//        // find information to return based on account role
//        String role = account.getAppRole().getRoleName();
//        String fullName;
//        switch (role) {
//            case "Admin":
//                fullName = account.getAppAdmin().getFullName();
//                break;
//            case "Teacher":
//                fullName = account.getTeacher().getFullName();
//                break;
//            default:
//                fullName = account.getStudent().getFullName();
//        }
//
//        return ResponseEntity.ok(new JwtResponseNew(id, username, token, fullName, role));
//    }
//    // method that do the authentication process
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
}
