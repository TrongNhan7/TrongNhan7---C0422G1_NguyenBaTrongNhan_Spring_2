package com.codegym.service.impl;


import com.codegym.model.AppRole;
import com.codegym.repository.IAppRoleRepository;
import com.codegym.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {

    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Override
    public List<AppRole> findByUsername(String username) {
        return this.appRoleRepository.findByUsernameAsRole(username);
    }
}
