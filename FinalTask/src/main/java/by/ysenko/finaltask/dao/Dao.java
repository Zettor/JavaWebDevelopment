package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.Bean;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Dao<T extends Bean> {
    public abstract List<T> findAll() throws PersistentException;

    public abstract T findEntityById(int id) throws PersistentException;

    public abstract boolean delete(int id) throws SQLException;

    public abstract boolean delete(T entity) throws SQLException;

    public abstract Integer create(T entity) throws PersistentException;

    public abstract void update(T entity) throws PersistentException;

    public void close(Statement st);

    public void setConnection(Connection connection);
}

