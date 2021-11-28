package com.sbrf.reboot;

import com.sbrf.reboot.service.Account;
import com.sbrf.reboot.service.AccountRepository;
import com.sbrf.reboot.service.AccountRepositoryImpl;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        //double res=Calculator.getDivision(1,3);
        //System.out.println(res);
        AccountRepository accountRepository;
        accountRepository = new AccountRepositoryImpl("src/main/java/com/sbrf/reboot/service/Accounts.txt");
        Set<Account> a=accountRepository.getAllAccountsByClientId(1);
        System.out.println(a.contains("ACC123NUM"));
    }
}
