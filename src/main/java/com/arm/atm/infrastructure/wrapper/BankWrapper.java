package com.arm.atm.infrastructure.wrapper;

import com.arm.atm.entity.Bank;
import com.arm.atm.infrastructure.deserializer.BankDeserialize;
import com.arm.atm.infrastructure.serializer.BankSerialize;
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
