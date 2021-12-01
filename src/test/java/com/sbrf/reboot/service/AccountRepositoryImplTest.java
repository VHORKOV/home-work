package com.sbrf.reboot.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    @Test
    void getAllAccountsByClientId() throws IOException {
        accountRepository = new AccountRepositoryImpl("src/main/java/com/sbrf/reboot/service/Accounts.txt");
        //как составить тест
        //assertTrue(accountRepository.getAllAccountsByClientId(1).contains("ACC123NUM"));
    }
}
