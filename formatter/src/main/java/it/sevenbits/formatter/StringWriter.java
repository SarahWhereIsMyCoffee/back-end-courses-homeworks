package it.sevenbits.formatter;

import java.io.IOException;

public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    public StringWriter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void write(char character) throws IOException {
        stringBuilder.append(character);
    }

    @Override
    public void write(String string) throws IOException {
        stringBuilder.append(string);
    }
}
