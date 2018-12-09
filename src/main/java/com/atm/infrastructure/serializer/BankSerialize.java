package com.atm.infrastructure.serializer;

import com.atm.entity.Bank;
import com.atm.infrastructure.wrapper.BankWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BankSerialize extends JsonSerializer<BankWrapper> {
    @Override
    public void serialize(BankWrapper bankWrapper,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        Bank bank = bankWrapper.getBankAccount();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("bankId", bank.getId());
        jsonGenerator.writeStringField("bankName",bank.getBankName());
        jsonGenerator.writeEndObject();
    }
}
