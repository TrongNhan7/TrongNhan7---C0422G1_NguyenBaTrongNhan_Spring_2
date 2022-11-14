package com.codegym.repository;


import com.codegym.model.Account;
import com.codegym.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAppUserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);


    @Transactional
    @Modifying
    @Query(value = "UPDATE app_user SET `password` = :newPassword WHERE username = :username",nativeQuery = true)
    void resetPassword(@Param("username")String username, @Param("newPassword") String newPassword);

    @Query(value = "SELECT \n" +
            "    u.id, u.password, u.username, u.employee_id\n" +
            "FROM\n" +
            "    app_user AS u\n" +
            "        JOIN\n" +
            "    employee AS e ON u.employee_id = e.id\n" +
            "WHERE\n" +
            "    e.email = :email",nativeQuery = true)
    AppUser findByEmail(@Param("email") String email);
}
