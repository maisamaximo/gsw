package com.atm.controller;

import com.atm.entity.Account;
import com.atm.infrastructure.wrapper.BankNoteWrapper;
import com.atm.repository.AccountRepository;
import com.atm.services.AccountService;
import com.atm.services.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atm")
public class AtmController {

    Withdraw withdraw;
    AccountService accountService;
    AccountRepository accountRepository;

    @Autowired
    public AtmController(Withdraw withdraw, AccountService accountService, AccountRepository accountRepository){
        this.withdraw = withdraw;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/withdrawOperation/{accountNumber}")
    public ResponseEntity<?> setWithdraw(
            @PathVariable String accountNumber,
            @RequestParam double value
    ) throws Exception {
        Account account = accountService.getLoggedAccountAccountNumber(accountNumber);
        withdraw.accountWithdraw(account, value);
        accountRepository.save(account);
        BankNoteWrapper wrapper = new BankNoteWrapper(withdraw.getBankNote());
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
