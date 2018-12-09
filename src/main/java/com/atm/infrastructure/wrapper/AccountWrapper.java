package com.atm.infrastructure.wrapper;

import com.atm.entity.Account;
import com.atm.infrastructure.deserializer.AccountDeserialize;
import com.atm.infrastructure.serializer.AccountSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AccountSerialize.class)
@JsonDeserialize(using = AccountDeserialize.class)
public class AccountWrapper {

    private final Account account;

    public AccountWrapper(final Account account){
        this.account = account;
    }

    public Account getAccount(){
        return account;
    }

}
