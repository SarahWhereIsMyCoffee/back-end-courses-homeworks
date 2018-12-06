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

    /**
     * Method for the writing a symbol to file.
     * @param character - symbol we append to the line
     * @throws IOException
     */
    @Override
    public void write(final char character) throws IOException {
        stringBuilder.append(character);
    }

    /**
     * Method for the writing a symbol to file.
     * @param string -  we string to the line
     * @throws IOException
     */
    @Override
    public void write(final String string) throws IOException {
        stringBuilder.append(string);
    }

    /**
     * Method for closing the stream.
     * @throws IOException -  Exception that can be thrown during the method work.
     */
    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
