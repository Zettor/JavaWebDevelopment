package by.yasenko.task2.dao.exception;

/**
 * It is Exception related with Reader.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class ReaderException extends Exception {

    /**
     * Constructor - create a new ReaderException.
     */
    public ReaderException() {
        super();
    }

    /**
     * Constructor - create a new ReaderException with special parameters.
     *
     * @param message - message of exception.
     */
    public ReaderException(final String message) {
        super(message);
    }

    /**
     * Constructor - create a new ReaderException with special parameters.
     *
     * @param e - some exception
     */
    public ReaderException(final Exception e) {
        super(e);
    }

    /**
     * Constructor - create a new ReaderException with special parameters.
     *
     * @param message - message of exception.
     * @param e - some exception.
     */
    public ReaderException(final String message, final Exception e) {
        super(message, e);
    }

}
