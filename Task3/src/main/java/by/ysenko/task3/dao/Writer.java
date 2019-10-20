package by.ysenko.task3.dao;

import by.ysenko.task3.dao.exception.WriterException;

import java.util.List;

/**
 * Interface for WriterImpl class.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface Writer {

    /**
     * Method of writting data to file.
     *
     * @param path - path to file.
     * @param data - data in ArrayList.
     * @throws WriterException - when method got wrong path.
     */
    void write(String path, List<String> data) throws WriterException;
}
