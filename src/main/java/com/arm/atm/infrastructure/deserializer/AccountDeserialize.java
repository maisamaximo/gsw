package com.arm.atm.infrastructure.deserializer;

import com.arm.atm.entity.Account;
import com.arm.atm.infrastructure.wrapper.AccountWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;


public class AccountDeserialize extends JsonDeserializer<AccountWrapper> {
    @Override
    public AccountWrapper deserialize(JsonParser jsonParser,
                                      DeserializationContext deserializationContext)
            throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        final String accountNumber = jsonNode.get("accountNumber").asText();
        final String accountOwner = jsonNode.get("accountOwner").asText();
        final double accountBalance = jsonNode.get("accountBalance").asDouble();
        final String accountPassword = jsonNode.get("accountPassword").asText();

        return new AccountWrapper(new Account(accountNumber, accountOwner, accountBalance, accountPassword));
    }
}
