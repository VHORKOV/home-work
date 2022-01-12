package com.sbrf.reboot.service;

import lombok.RequiredArgsConstructor;


import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository{
    private final String fileAccounts; //="/Users/a16706828/Desktop/IDEA_Projects/Java_Study/src/main/java/com/sbrf/reboot/service/Accounts.txt";

    public Set<Account> getAccounts()  throws IOException{
        Set<Account> accounts = new HashSet<>();

        InputStream inputStream;
        Reader inputStreamReader;

        inputStream = new FileInputStream(fileAccounts);
        inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] array=line.split(",");
                System.out.println(array[0]);
                accounts.add(new Account(Long.parseLong(array[0]),Long.parseLong(array[1]), LocalDate.now(), BigDecimal.ZERO));
            }
        }catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }

        inputStream.close();
        inputStreamReader.close();
        return accounts;
    }
    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        try {
            this.getAccounts();
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }

        return
                getAccounts()
                .stream()
                .filter(account -> account.getClientId() == clientId)
                .collect(Collectors.toSet());


    }


}
