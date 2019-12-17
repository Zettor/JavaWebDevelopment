package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.Bean;
import by.ysenko.finaltask.dao.exception.DaoException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface Dao<T extends Bean> {
    public abstract List<T> findAll() throws DaoException;

    public abstract T findEntityById(int id) throws DaoException;

    public abstract void delete(int id) throws DaoException;

    public abstract boolean delete(T entity) throws DaoException;

    public abstract Integer create(T entity) throws DaoException;

    public abstract void update(T entity) throws DaoException;

    public void close(Statement st);

    public void setConnection(Connection connection);
}

