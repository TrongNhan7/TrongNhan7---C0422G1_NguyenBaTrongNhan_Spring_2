package com.codegym.service;



import com.codegym.model.AppRole;

import java.util.List;

public interface IAppRoleService {

    List<AppRole> findByUsername(String username);
}
