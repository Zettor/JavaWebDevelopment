package by.yasenko.task2.dao;



import by.yasenko.task2.dao.exception.ReaderException;

import java.util.ArrayList;

/**
 * Interface for ReaderImpl class.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface Reader {

    /**
     * Method of getting data from file.
     *
     * @param path - path to file.
     * @return ArrayList of String's with data.
     * @throws ReaderException - exception in ReaderImpl.
     */
    ArrayList<String> read(String path) throws ReaderException;

}
