package com.arm.atm.controller;


import com.arm.atm.entity.Account;
import com.arm.atm.infrastructure.wrapper.AccountWrapper;
import com.arm.atm.repository.AccountRepository;
import com.arm.atm.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    public AccountRepository accountRepository;
    public AccountService accountService;

    @Autowired
    public AccountController(AccountRepository  AccountRepository, AccountService accountService) {
        this.accountRepository = AccountRepository;
        this.accountService =accountService;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody AccountWrapper newAccount) {
        accountRepository.save(newAccount.getAccount());

        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.CREATED);
    }

    @PostMapping(value = "/deleteAccount/{idAccount}")
    public ResponseEntity<?> deleteAccount(@PathVariable long idAccount) {
        accountRepository.deleteById(idAccount);
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/allAccounts")
    public ResponseEntity<?> getAllAccounts() {
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/logedAccounts")
    public ResponseEntity<?> getLogedAccounts() {
        return new ResponseEntity<>(accountService.getLogedAccounts(), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    private ResponseEntity<?> validateAccount(@RequestBody LoginAccount loginAccount) throws Exception {

        Account existingAccount = accountRepository.findByAccountNumberAndAccountPassword(loginAccount.getAccountNumber(), loginAccount.getAccountPassword());
        Optional.ofNullable(existingAccount).orElseThrow(()-> new RuntimeException("Invalid Number Account or password"));
        accountService.addNewLogedAccount(existingAccount);
        return new ResponseEntity<>(existingAccount, HttpStatus.OK);
    }
}
    class LoginAccount{
    private String accountNumber;
    private String accountPassword;

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountPassword() {
            return accountPassword;
        }
    }