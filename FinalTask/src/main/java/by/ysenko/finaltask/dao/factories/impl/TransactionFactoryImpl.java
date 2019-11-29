package by.ysenko.finaltask.dao.factories.impl;

import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.factories.TransactionFactory;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.impl.TransactionImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class TransactionFactoryImpl implements TransactionFactory {
    private static Logger logger = LogManager.getLogger(TransactionFactoryImpl.class);

    @Override
    public Transaction createTransaction() throws PersistentException {
        return new TransactionImpl();
    }


}