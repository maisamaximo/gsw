package com.arm.atm.infrastructure.serializer;

import com.arm.atm.entity.BankNote;
import com.arm.atm.infrastructure.wrapper.BankNoteWrapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BankNoteSerialize extends JsonSerializer<BankNoteWrapper> {
    @Override
    public void serialize(BankNoteWrapper bankNoteWrapper,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        BankNote bankNote = bankNoteWrapper.getBankNote();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("bankNote100", bankNote.getN100());
        jsonGenerator.writeNumberField("bankNote50", bankNote.getN50());
        jsonGenerator.writeNumberField("bankNote20", bankNote.getN20());
        jsonGenerator.writeNumberField("bankNote10", bankNote.getN10());
        jsonGenerator.writeEndObject();
    }
}
