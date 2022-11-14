package com.codegym.service.impl;

import com.codegym.model.Account;
import com.codegym.model.AppUser;
import com.codegym.repository.IAppUserRepository;
import com.codegym.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public Account findByUsername(String username) {
        return this.appUserRepository.findByUsername(username);
    }

    @Override
    public void resetPassword(String username, String newPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String encodePassword = bCryptPasswordEncoder.encode(newPassword);
        this.appUserRepository.resetPassword(username, encodePassword);
    }

    @Override
    public AppUser findByEmail(String email) {
        return this.appUserRepository.findByEmail(email);
    }

}
