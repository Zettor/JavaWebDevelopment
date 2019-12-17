package by.ysenko.finaltask.dao.factories.impl;

import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.factories.TransactionFactory;
import by.ysenko.finaltask.dao.connection.ConnectionPool;
import by.ysenko.finaltask.dao.impl.TransactionImpl;


public class TransactionFactoryImpl implements TransactionFactory {


    @Override
    public Transaction createTransaction() {
        return new TransactionImpl();
    }

    @Override
    public void init() {
        ConnectionPool.getInstance().init();
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().destroy();
    }

}