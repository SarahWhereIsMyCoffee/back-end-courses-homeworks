package it.sevenbits.formatter.io.writer;

import it.sevenbits.formatter.io.writer.IWriter;

import java.io.IOException;

/**
 * StringWriter class implements of IWriter interface and using for the writing chars in out line.
 * Has a constructor, and also overrides method toString().
 */
public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    /**
     * Constructor for the StringWriter class
     * Initializes stringBuilder
     */
    public StringWriter() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void write(final char character) throws IOException {
        stringBuilder.append(character);
    }

    @Override
    public void write(final String string) throws IOException {
        stringBuilder.append(string);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
