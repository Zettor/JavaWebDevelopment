package by.ysenko.task4.service.exception;

/**
 * It is Exception related with Service.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class ServiceException extends Exception {

    /**
     * Constructor - create a new ServiceException.
     */
    public ServiceException() {
        super();
    }


    /**
     * Constructor - create a new ServiceException with special parameters.
     *
     * @param message - message of exception.
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Constructor - create a new ServiceException with special parameters.
     *
     * @param e - some exception
     */
    public ServiceException(final Exception e) {
        super(e);
    }

    /**
     * Constructor - create a new ServiceException with special parameters.
     *
     * @param message - message of exception.
     * @param e       - some exception.
     */
    public ServiceException(final String message, final Exception e) {
        super(message, e);
    }
}
