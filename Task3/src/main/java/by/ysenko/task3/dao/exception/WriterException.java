package by.ysenko.task3.dao.exception;

/**
 * It is Exception related with Writer.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class WriterException extends Exception {

    /**
     * Constructor - create a new WriterException.
     */
    public WriterException() {
        super();
    }

    /**
     * Constructor - create a new WriterException with special parameters.
     *
     * @param message - message of exception.
     */
    public WriterException(final String message) {
        super(message);
    }

    /**
     * Constructor - create a new WriterException with special parameters.
     *
     * @param e - some exception
     */
    public WriterException(final Exception e) {
        super(e);
    }

    /**
     * Constructor - create a new WriterException with special parameters.
     *
     * @param message - message of exception.
     * @param e       - some exception.
     */
    public WriterException(final String message, final Exception e) {
        super(message, e);
    }
}
