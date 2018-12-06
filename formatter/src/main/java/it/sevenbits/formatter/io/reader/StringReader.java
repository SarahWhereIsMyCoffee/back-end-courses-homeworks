package it.sevenbits.formatter.io.reader;

import it.sevenbits.formatter.io.reader.IReader;

import java.io.EOFException;
import java.io.IOException;

/**
 * StringReader class implements of IReader interface.
 * Not only overrides methods of implemented interface, but also has a constructor.
 */
public class StringReader implements IReader {
    private String string;
    private int index;
    /**
     * Constructor for StringReader class
     * @param string - methods gets some line from which we read chars
     */
    public StringReader(final String string) {
        this.string = string;
        index = 0;
    }

    /**
     * Method to check, if reader has next character
     * @return - returns boolean: true if it has, false in different case.
     */
    @Override
    public boolean hasNext() {
        return index < string.length();
    }
    /**
     * Method to get next character.
     * @return - next character
     * @throws IOException - Exception that can be thrown during the method work.
     */
    @Override
    public int read() throws IOException {
        if (!hasNext()) {
            throw new EOFException("Read Error");
        }
        return string.charAt(index++);
    }
}

