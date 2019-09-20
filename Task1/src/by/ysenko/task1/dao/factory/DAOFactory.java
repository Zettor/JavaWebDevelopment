package by.ysenko.task1.dao.factory;

import by.ysenko.task1.dao.Impl.ReaderImpl;
import by.ysenko.task1.dao.Impl.WriterImpl;
import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.Writer;


public final class DAOFactory {

    private final Reader reader = new ReaderImpl();

    private final Writer writer = new WriterImpl();

    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }
}
