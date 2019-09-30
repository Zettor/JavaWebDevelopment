package by.yasenko.task2.dao.factory;


import by.yasenko.task2.dao.Reader;
import by.yasenko.task2.dao.impl.ReaderImpl;

/**
 * It is class with Singleton pattern,
 * where reader  instances are stored.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class DAOFactory {

    /**
     * Object of Reader class.
     */
    private final Reader reader = new ReaderImpl();


    /**
     * Instance of DAOFactory class.
     */
    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    /**
     * Method of getting instance.
     *
     * @return instance.
     */
    public static DAOFactory getInstance() {
        return instance;
    }

    /**
     * Method of getting reader.
     *
     * @return reader.
     */
    public Reader getReader() {
        return reader;
    }


}
