package by.ysenko.task1.dao.factory;

import by.ysenko.task1.dao.Impl.ReaderImpl;
import by.ysenko.task1.dao.Reader;


public final class DAOFactory {

    private final Reader reader = new ReaderImpl();

    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public Reader getReader() {
        return reader;
    }
}
