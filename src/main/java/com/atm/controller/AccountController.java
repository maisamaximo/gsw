package com.atm.controller;


import com.atm.entity.Account;
import com.atm.infrastructure.wrapper.AccountWrapper;
import com.atm.repository.AccountRepository;
import com.atm.services.AccountService;
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

    @GetMapping("/loggedAccounts")
    public ResponseEntity<?> getLoggedAccounts() {
        return new ResponseEntity<>(accountService.getLoggedAccounts(), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    private ResponseEntity<?> validateAccount(@RequestBody LoginAccount loginAccount) throws Exception {

        Account existingAccount = accountRepository.findByAccountNumberAndAccountPassword(loginAccount.getAccountNumber(), loginAccount.getAccountPassword());
        Optional.ofNullable(existingAccount).orElseThrow(()-> new RuntimeException("Invalid Number Account or password"));
        accountService.addNewLoggedAccount(existingAccount);
        return new ResponseEntity<>(existingAccount, HttpStatus.OK);
    }

    @GetMapping(value = "/logout/{accountNumber}")
    public ResponseEntity<?> removeLoggedAccount(@PathVariable String accountNumber){
        accountService.removeLoggedAccount(accountNumber);
        return new ResponseEntity<>(HttpStatus.OK);
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