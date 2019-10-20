package by.ysenko.task3.dao.factory;


import by.ysenko.task3.dao.Reader;
import by.ysenko.task3.dao.Writer;
import by.ysenko.task3.dao.impl.ReaderImpl;
import by.ysenko.task3.dao.impl.WriterImpl;

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
     * Object of Writer class.
     */
    private final Writer writer = new WriterImpl();

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
    public  Reader getReader() {
        return reader;
    }

    /**
     * Method of getting writer.
     *
     * @return writer.
     */
    public Writer getWriter() {
        return writer;
    }


}
