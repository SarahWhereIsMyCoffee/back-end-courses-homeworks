package it.sevenbits.formatter;

import java.io.EOFException;
import java.io.IOException;

public class StringReader implements IReader {
    private String string;
    private int index;

    public StringReader(String string) {
        this.string = string;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < string.length();
    }

    @Override
    public int read() throws IOException {
        if (!hasNext()) {
            throw new EOFException("Read Error");
        }
        return string.charAt(index++);
    }
}

