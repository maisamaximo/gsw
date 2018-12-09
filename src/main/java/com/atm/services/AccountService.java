package com.atm.services;

import com.atm.entity.Account;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    List<Account> loggedAccounts = new ArrayList<>();

    public List<Account> getLoggedAccounts(){
        return loggedAccounts;
    }

    public void addNewLoggedAccount(Account account) throws Exception {
        if (loggedAccounts.size() <= 4 ){
            if (!isAccountLogged(account.getAccountNumber())){
                this.loggedAccounts.add(account);
            } else throw new Exception("User already logged");

        } else throw new Exception("Limit of logged in users");
    }

    public void removeLoggedAccount(String accountNumber) {
        if (isAccountLogged(accountNumber)) {
            final Account account = getLoggedAccountAccountNumber(accountNumber);
            loggedAccounts.remove(account);
        }
    }

    public Account getLoggedAccountAccountNumber(String accountNumber) {
        return loggedAccounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isAccountLogged(String accountNumber) {
        return loggedAccounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findAny()
                .isPresent();
    }
}