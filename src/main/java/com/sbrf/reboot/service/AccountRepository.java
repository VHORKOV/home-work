package com.sbrf.reboot.service;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long id) throws IOException;
    //Account setAccountNumber(long clientId, String oldnumber, String newNumber);
}
