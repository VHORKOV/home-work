package com.sbrf.reboot.utils;

import com.sbrf.reboot.service.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static void sortedById(List<Account> accounts) {
        Comparator<Account> comparator=Comparator.comparing(account -> account.getClientId());
        Collections.sort(accounts,comparator);
    }

    public static void sortedByIdDate(List<Account> accounts) {
        Comparator<Account> comparator=Comparator.comparing(account->account.getClientId());
        comparator=comparator.thenComparing(account -> account.getCreateDate());
        Collections.sort(accounts,comparator);
    }

    public static void sortedByIdDateBalance(List<Account> accounts) {
        Comparator<Account> comparator=Comparator.comparing(account->account.getClientId());
        comparator=comparator.thenComparing(account -> account.getCreateDate());
        comparator=comparator.thenComparing(account -> account.getBalance());
        Collections.sort(accounts,comparator);
    }
}
