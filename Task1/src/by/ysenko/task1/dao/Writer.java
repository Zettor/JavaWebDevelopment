package by.ysenko.task1.dao;

import by.ysenko.task1.dao.exception.WriterException;

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
     */
    void write(String path, List<String> data) throws WriterException;
}
