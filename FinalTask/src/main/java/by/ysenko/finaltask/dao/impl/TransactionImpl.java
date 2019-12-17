package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {

    private final Logger logger = LogManager.getLogger(getClass().getName());

    private Connection connection;

    public void begin(Dao dao, Dao... daos) {

        logger.debug("start transaction");
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
            logger.error(e);
        }
    }


    public void end() {
        try {
            connection.setAutoCommit(true);
            logger.debug("end transaction");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void commit() {
        try {
            logger.debug("commit transaction");
            connection.commit();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void rollback() {
        try {
            logger.debug("rollback transaction");
            connection.rollback();
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
