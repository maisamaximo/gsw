package com.arm.atm.data;

import com.arm.atm.entity.Account;
import com.arm.atm.entity.Bank;
import com.arm.atm.repository.AccountRepository;
import com.arm.atm.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtmData implements CommandLineRunner {

    private BankRepository bankRepository;

    private AccountRepository accountRepository;

    @Autowired
    public AtmData(AccountRepository accountRepository, BankRepository bankRepository){
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("605823498","Maisa Maximo", 30000.00, "adm"));
        accountList.add(new Account("937328098", "Lucas Rosa", 50400.00, "adm"));
        accountList.add(new Account("971251708", "Roberto Perillo", 2000.00, "adm"));
        accountList.add(new Account("590113348", "Raphael Simoes", 600.00, "adm"));
        accountList.add(new Account("460810438", "Breno de Avila", 5500.00, "adm"));
        accountList.add(new Account("653784018", "Mauro Ferreira", 205.00, "adm"));

        accountRepository.saveAll(accountList);

        List<Bank> bankList = new ArrayList<>();
        bankList.add(new Bank("Itau"));
        bankList.add(new Bank("Santander"));
        bankList.add(new Bank("Banco do Brasil"));

        bankRepository.saveAll(bankList);
    }
}
