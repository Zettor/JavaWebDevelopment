package by.ysenko.task3.bean.exception;

public class BeanException extends Exception {
    /**
     * Constructor - create a new BeanException.
     */
    public BeanException() {
        super();
    }


    /**
     * Constructor - create a new BeanException with special parameters.
     *
     * @param message - message of exception.
     */
    public BeanException(final String message) {
        super(message);
    }

    /**
     * Constructor - create a new BeanException with special parameters.
     *
     * @param e - some exception
     */
    public BeanException(final Exception e) {
        super(e);
    }

    /**
     * Constructor - create a new BeanException with special parameters.
     *
     * @param message - message of exception.
     * @param e       - some exception.
     */
    public BeanException(final String message, final Exception e) {
        super(message, e);
    }
}
