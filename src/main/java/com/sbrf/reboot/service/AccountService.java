package com.sbrf.reboot.service;

import java.io.IOException;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long id, Account account) throws IOException {
        return accountRepository.getAllAccountsByClientId(id).contains(account);
    }
}