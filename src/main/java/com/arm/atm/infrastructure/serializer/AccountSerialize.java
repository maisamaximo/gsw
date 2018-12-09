package com.arm.atm.infrastructure.serializer;

import com.arm.atm.entity.Account;
import com.arm.atm.infrastructure.wrapper.AccountWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AccountSerialize extends JsonSerializer<AccountWrapper> {

    @Override
    public void serialize(AccountWrapper accountWrapper,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        Account account = accountWrapper.getAccount();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("accountNumber",account.getAccountNumber());
        jsonGenerator.writeStringField("accountOwner", account.getAccountOwner());
        jsonGenerator.writeNumberField("accountBalance", account.getAccountBalance());

        jsonGenerator.writeEndObject();
    }
}
