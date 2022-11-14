package com.codegym.repository;


import com.codegym.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {

    @Query(value = "SELECT " +
            "    * " +
            "FROM " +
            "    app_role as a " +
            "        JOIN " +
            "    account_role as ar ON a.id = ar.role_id " +
            "        JOIN " +
            "    account as ac ON ar.account_id = ac.id " +
            "WHERE " +
            "    ac.username = :username", nativeQuery = true)
    List<AppRole> findByUsernameAsRole(@Param("username") String username);

}
