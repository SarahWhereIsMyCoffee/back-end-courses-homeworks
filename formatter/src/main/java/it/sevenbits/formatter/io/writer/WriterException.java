package it.sevenbits.formatter.io.writer;

/**
 * This exception is used by implementations of writer interface.
 */
public class WriterException extends Exception {

    /**
     * Class constructor with specifying of an error message.
     *
     * @param message nstance that will be contained in the thrown instance of exception.
     */
    public WriterException(final String message) {
        super(message);
    }

    /**
     * Class constructor with specifying of an error message and {@link Throwable} cause of exception throwing.
     *
     * @param message instance that will be contained in the thrown instance of exception.
     * @param cause   An instance of that caused the situation in which exception was thrown.
     */
    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}