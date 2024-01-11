package com.example.medical_supplies.service.auth;

import com.example.medical_supplies.model.auth.Account;

import java.util.Optional;

public interface IAccountService {
    /**
     * Finds an account by email.
     * @author: NamND
     * @date: 10/01/2024
     * @param email The email.
     * @return An optional containing the account if found, or an empty optional if not found.
     */
    Optional<Account> findByEmail(String email);

    /**
     * Checks if an account exists by email.
     * @author: NamND
     * @date: 10/01/2024
     * @param email The email.
     * @return true if the account exists, false otherwise.
     */
    Boolean existsByEmail(String email);

    /**
     * Get Account By Email.
     * @author: NamND
     * @date: 10/01/2024
     * @param account The account to be saved.
     * @return account if true, otherwise null
     */
    Account addAccount(Account account);
    void addAccountRole (int idAccount,int idRole);
}
