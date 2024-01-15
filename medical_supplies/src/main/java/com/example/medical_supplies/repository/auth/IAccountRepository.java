package com.example.medical_supplies.repository.auth;

import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class IAccountRepository extends class JpaRepository.
 * @author: NamND
 * @date: 10/01/2024
 */
public interface IAccountRepository extends JpaRepository<Account,Long> {

    /**
     * Get Information Account by Email
     * @author: NamND
     * @date: 10/01/2024
     * @param email to find email
     * @return Optional<Account>
     */
    @Query(value = "SELECT * FROM accounts as a WHERE a.email = :email", nativeQuery = true)
    Optional<Account> findByEmail(@Param("email") String email);

    @Query(value = "SELECT accounts.* FROM accounts WHERE email = :email", nativeQuery = true)
    Account getAccountByEmail(@Param("email") String email);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO accounts (email,password) " +
            "VALUES ( :#{#account.email}, :#{#account.password} ) ", nativeQuery = true)
    void addAccount(@Param("account") Account account);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO account_role (id_account,id_role) " +
            "VALUES ( :idAccount, :idRole ) ", nativeQuery = true)
    void addAccountRole(@Param("idAccount") int idAccount,@Param("idRole") int idRole);


}
