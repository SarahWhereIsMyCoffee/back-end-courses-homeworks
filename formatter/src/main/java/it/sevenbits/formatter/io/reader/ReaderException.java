package it.sevenbits.formatter.io.reader;

import java.io.IOException;

/**
 * This exception is used by implementations of reader interface.
 */
public class ReaderException extends IOException {
    /**
     * Class constructor with specifying of an error message.
     *
     * @param message instance that will be contained in the thrown instance of exception.
     */
    public ReaderException(final String message) {
        super(message);
    }
}
