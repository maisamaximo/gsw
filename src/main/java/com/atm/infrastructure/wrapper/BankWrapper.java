package com.atm.infrastructure.wrapper;

import com.atm.entity.Bank;
import com.atm.infrastructure.deserializer.BankDeserialize;
import com.atm.infrastructure.serializer.BankSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BankSerialize.class)
@JsonDeserialize(using = BankDeserialize.class)
public class BankWrapper {

    private final Bank bankAccount;

    public BankWrapper(final Bank bankAccount){
        this.bankAccount = bankAccount;
    }

    public Bank getBankAccount(){
        return bankAccount;
    }
}
