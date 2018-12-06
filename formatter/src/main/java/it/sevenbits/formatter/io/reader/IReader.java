package it.sevenbits.formatter.io.reader;


import java.io.IOException;

/**
 * Interface IReader is needed for the Formatter.
 * It has two methods, one of which checks, if the string has next char,
 *  * and the other get next char in case in exists.
 */
public interface IReader {
    /**
     * Checks, if the line has a next char.
     * @return true in case of line has a next char, and false, if it don't
     */
    boolean hasNext();

    /**
     * Reads next char, if it exists.
     * @return char we read.
     * @throws IOException in case of read error.
     */
    int read() throws IOException;
}
