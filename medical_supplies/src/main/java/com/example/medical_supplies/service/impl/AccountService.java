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

    @Override
    public void updatePassword(Account account) {
        accountRepository.updatePasswordAccount(account.getEmail(),account.getPassword());
    }


    @Override
    public Account addAccount(Account account) {
        try {
            accountRepository.addAccount(account);
           Account accountNew =  accountRepository.getAccountByEmail(account.getEmail());
            return accountNew;
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public void addAccountRole(int idAccount,int idRole ) {
        try {
            accountRepository.addAccountRole(idAccount,idRole);
        }catch (Exception e){
            e.getMessage();
        }

    }

}
