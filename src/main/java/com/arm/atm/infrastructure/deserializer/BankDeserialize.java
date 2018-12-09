package com.arm.atm.infrastructure.deserializer;

import com.arm.atm.entity.Bank;
import com.arm.atm.infrastructure.wrapper.BankNoteWrapper;
import com.arm.atm.infrastructure.wrapper.BankWrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class BankDeserialize extends JsonDeserializer<BankWrapper> {
    @Override
    public BankWrapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        final String bankName = jsonNode.get("bankName").asText();

        return new BankWrapper(new Bank(bankName));
    }
}
