package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {

    private Connection connection;

    public void begin(Dao dao, Dao... daos)  {

        if (connection == null) {
            connection = ConnectionPool.getInstance().getConnection();
        }

        dao.setConnection(connection);
        for (Dao temp : daos) {
            temp.setConnection(connection);
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {

        }
    }



    public void end() {
        try {
            connection.setAutoCommit(true);

        } catch (SQLException e) {

        }
    }

    @Override
    public void commit()  {
        try {
            connection.commit();
        } catch (SQLException e) {

        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {

        }
    }
}
