package by.ysenko.task1.dao;

import by.ysenko.task1.dao.exception.WriterException;

import java.util.List;

public interface Writer {

    public void write(final String path, final List<String> date) throws WriterException;
}
