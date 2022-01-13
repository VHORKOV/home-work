package com.sbrf.reboot.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(long id, Account account) throws IOException {
        return accountRepository.getAllAccountsByClientId(id).contains(account);
    }
    public BigDecimal getMaxAccountBalance(long clientId) throws IOException {
        Stream<Account> stream = accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.max(Comparator.comparing(account -> account.getBalance())).get().getBalance();
    }

    public Set<Account> getAllAccountsByDateMoreThen(long clientId, LocalDate localDate) throws IOException {
        Stream<Account> stream = accountRepository.getAllAccountsByClientId(clientId).stream();
        return stream.filter(accountNew -> accountNew.getCreateDate().isAfter(localDate)|| accountNew.getCreateDate().isEqual(localDate)).collect(Collectors.toSet());
    }

}