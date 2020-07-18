package com.example.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.exception.ValidateFailedException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    AccountRepository accountRepository;

    /**
     * @param username
     * @param password
     * @return 通過驗證的使用者資料
     * @throws ValidateFailedException
     */
    public Account validateLogin(String username, String password) throws ValidateFailedException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new ValidateFailedException("account not found");
        }

        if (!BCrypt.verifyer().verify(password.toCharArray(), account.getPassword()).verified) {
            throw new ValidateFailedException("password not correct");
        }

        return account;
    }
}

