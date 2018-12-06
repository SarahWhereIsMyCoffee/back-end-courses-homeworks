package it.sevenbits.formatter.io.writer;

import java.io.IOException;

/**
 * Interface IWriter is needed for the Formatter.
 * It contains two overloaded methods write(), one of each appends a char to the line,
 * so other appends a string to our line.
 */
public interface IWriter {
    /**
     *
     * @param character - symbol we append to the line
     * @throws IOException - in case of some writing error
     */
    void write(char character) throws IOException;

    /**
     *
     * @param string - string we append to the line
     * @throws IOException - in case of some writing error
     */
    void write(String string) throws IOException;
}
