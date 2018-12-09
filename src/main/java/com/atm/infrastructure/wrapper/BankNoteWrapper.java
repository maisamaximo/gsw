package com.atm.infrastructure.wrapper;

import com.atm.entity.BankNote;
import com.atm.infrastructure.serializer.BankNoteSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BankNoteSerialize.class)
public class BankNoteWrapper {

    private final BankNote bankNote;

    public BankNoteWrapper(final BankNote bankNote){
        this.bankNote = bankNote;
    }

    public BankNote getBankNote(){
        return bankNote;
    }
}
