package by.ysenko.finaltask.dao.exception;

public class DaoException extends Exception {


    public DaoException() {
        super();
    }



    public DaoException(final String message) {
        super(message);
    }


    public DaoException(final Exception e) {
        super(e);
    }


    public DaoException(final String message, final Exception e) {
        super(message, e);
    }
}
