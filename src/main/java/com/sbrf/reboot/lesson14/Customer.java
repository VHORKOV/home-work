package com.sbrf.reboot.lesson14;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public class Customer {

    private int age;

    private String name;

    private Set<Account> accounts;

    public Stream<Account> getAccounts() {
        return accounts.stream();
    }
}
