package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.AppAccount;
import com.sprint3.backend.repository.AppAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService {
//    @Autowired
//    AppAccountRepository appAccountRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppAccount user = appAccountRepository.findAccountByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return new User(user.getUsername(), user.getPassword(),
//                new ArrayList<>());
//    }
}
