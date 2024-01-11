package com.example.medical_supplies.repository.auth;

import com.example.medical_supplies.controller.auth.model.auth.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * Check exist Account by Username
     * @author: NamND
     * @date: 10/01/2024
     * @param email to find username
     * @return Boolean
     */
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM accounts as a WHERE a.email = :email", nativeQuery = true)
    Boolean existsByEmail(@Param("email") String email);

    /**
     * Get account by email
     * @author: NamND
     * @date: 10/01/2024
     * @param email The email of the account.
     */
    @Query(value = "SELECT accounts.* FROM accounts JOIN employees ON accounts.id = employees.id_account WHERE employees.email = :email", nativeQuery = true)
    Account getAccountByEmail(@Param("email") String email);
}
