package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {

    private static Logger logger = LogManager.getLogger(TransactionImpl.class);
    private Connection connection;

    public void begin(Dao dao, Dao... daos) throws PersistentException {

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
            throw new PersistentException(e);
        }
    }

    public UserDao createUserDao() throws PersistentException {

        UserDao dao = new UserDaoImpl();
        return dao;
    }

    public GameDao createGameDao() throws PersistentException {
        GameDao dao = new GameDaoImpl();
        return dao;
    }

    public GenreDao createGenreDao() throws PersistentException {
        GenreDao dao = new GenreDaoImpl();
        return dao;
    }

    public TradeGameOfferDao createTradeGameOfferDao() throws PersistentException {
        TradeGameOfferDao dao = new TradeGameOfferDaoImpl();
        return dao;
    }

    public TradeConsoleOfferDao createTradeConsoleOfferDao() throws PersistentException {
        TradeConsoleOfferDao dao = new TradeConsoleOfferDaoImpl();
        return dao;
    }

    public AccessoryCategoryDao createAccessoryCategoryDao() throws PersistentException {
        AccessoryCategoryDao dao = new AccessoryCategoryDaoImpl();
        return dao;
    }

    public ExchangeGameOfferDao createExchangeGameOfferDao() throws PersistentException {
        ExchangeGameOfferDao dao = new ExchangeGameOfferDaoImpl();
        return dao;
    }

    public void end() {
        try {
            connection.setAutoCommit(true);

        } catch (SQLException e) {

        }
    }

    @Override
    public void commit() throws PersistentException {
        try {
            connection.commit();
        } catch (SQLException e) {
            logger.error("It is impossible to commit transaction", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public void rollback() throws PersistentException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.error("It is impossible to rollback transaction", e);
            throw new PersistentException(e);
        }
    }
}
