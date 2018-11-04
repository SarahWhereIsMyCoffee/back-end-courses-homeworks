package it.sevenbits.formatter;

import java.io.IOException;

public interface IWriter {
    void write(char character) throws IOException;
    void write(String string) throws IOException;
}
