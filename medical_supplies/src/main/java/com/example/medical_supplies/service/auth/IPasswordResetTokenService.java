package com.example.medical_supplies.service.auth;

import com.example.medical_supplies.model.auth.Account;


public interface IPasswordResetTokenService {
    void createPasswordResetTokenForUser(PasswordResetToken passwordResetToken);
    Boolean existsByToken(String token);
    PasswordResetToken getPasswordResetToken(String token);
    PasswordResetToken getPasswordResetToken(Account account);
}
