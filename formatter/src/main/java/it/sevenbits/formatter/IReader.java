package it.sevenbits.formatter;


import java.io.IOException;

public interface IReader {
    boolean hasNext();
    int read() throws IOException;
}
