package com.codegym.service.impl;


import com.codegym.model.Account;
import com.codegym.model.AppRole;
import com.codegym.repository.IAppRoleRepository;
import com.codegym.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Autowired
    private IAppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account user = this.appUserRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Not found username in database");
        }

        List<AppRole> roleList = this.appRoleRepository.findByUsernameAsRole(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AppRole role : roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
