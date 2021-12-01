package com.sbrf.reboot.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
                accounts.add(new Account(Long.parseLong(array[0]),array[1]));
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
                .filter(account -> account.clientId == clientId) //зесь приходится делать clientid видимым, как этого избежать
                .collect(Collectors.toSet());


    }
}
