package by.ysenko.task1.dao;

import by.ysenko.task1.dao.exception.ReaderException;

import java.util.ArrayList;

public interface Reader {

    public ArrayList<String> read(final String path) throws ReaderException;

}
