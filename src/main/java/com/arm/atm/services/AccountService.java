package com.arm.atm.services;

import com.arm.atm.entity.Account;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    List<Account> logedAccounts = new ArrayList<>();

    public List<Account> getLogedAccounts(){
        return logedAccounts;
    }

    public void addNewLogedAccount(Account account) throws Exception {
        if (logedAccounts.size() <= 4){
            this.logedAccounts.add(account);
        } else throw new Exception("Limit of logged in users");
    }

    public Account getLogedAccountAccountNumber(String accountNumber) {
        return logedAccounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
