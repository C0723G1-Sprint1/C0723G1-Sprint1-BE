package com.example.medical_supplies.service.impl;

import com.example.medical_supplies.model.auth.Account;
import com.example.medical_supplies.repository.auth.IAccountRepository;
import com.example.medical_supplies.service.auth.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * This method finds an account by email.
     * @author: NamND
     * @date: 10/01/2024
     * @param email The email.
     * @return An optional containing the account if found, or an empty optional if not found.
     */
    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    /**
     * This method checks if an account exists by username.
     * @author: NamND
     * @date: 10/01/2024
     * @param email The username.
     * @return true if the account exists, false otherwise.
     */
    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    /**
     * This method update Password an account.
     * @author: NamND
     * @date: 10/01/2024
     * @param account The account to be updated.
     */
    @Override
    public Account getAccountByEmail(String email) {
        return accountRepository.getAccountByEmail(email);
    }
}
