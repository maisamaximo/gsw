package com.atm.services;

import com.atm.entity.Account;
import com.atm.entity.BankNote;
import org.springframework.stereotype.Service;

@Service
public class Withdraw {

    private BankNote bankNote;

    //hard coded
    public void accountWithdraw(Account account, double valor) throws Exception {

        BankNote bankNote = new BankNote();
        double balance = account.getAccountBalance();
        double total = valor;

        if(balance < valor) {
            throw new Exception("Insufficient balance");
        } if(valor > 0 && valor % 10 == 0) {
                bankNote.setN100( (int) valor / 100);
                valor = valor % 100;
                bankNote.setN50( (int) valor / 50);
                valor = valor % 50;
                bankNote.setN20((int) valor / 20);
                valor = valor % 20;
                bankNote.setN10((int) valor / 10);

                account.setAccountBalance(balance - total);
        }else{
            throw new Exception("Invalid operation. Available slips: 100, 50, 20, 10");
        }
        this.bankNote = bankNote;
    }

    public BankNote getBankNote() {
        return bankNote;
    }
}
