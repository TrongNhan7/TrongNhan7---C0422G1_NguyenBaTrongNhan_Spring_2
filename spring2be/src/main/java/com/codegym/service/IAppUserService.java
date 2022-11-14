package com.codegym.service;


import com.codegym.model.Account;
import com.codegym.model.AppUser;

public interface IAppUserService {

    Account findByUsername(String username);

    void resetPassword(String username, String newPassword);

    AppUser findByEmail(String email);
}
