package it.sevenbits.formatter.commonFormatter;

/**
 * Exception class that we use in IWriter instances and that can be thrown during the method work.
 */
public class FormatterException extends Exception {
    /**
     * Class constructor with specifying of an error message.
     *
     * @param message instance that will be contained in the thrown instance of exception.
     */
    public FormatterException(final String message) {
        super(message);
    }

    /**
     * Class constructor with specifying of an error message and {@link Throwable} cause of exception throwing.
     *
     * @param message instance that will be contained in the thrown instance of exception.
     * @param cause An instance of {@link Throwable} that caused the situation in which exception was thrown.
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
