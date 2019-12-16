package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.dao.factories.impl.TransactionFactoryImpl;
import by.ysenko.finaltask.service.ConnectionService;

public class ConnectionServiceImpl implements ConnectionService {
    @Override
    public void init() {
        new TransactionFactoryImpl().init();
    }

    @Override
    public void close() {
        new TransactionFactoryImpl().close();
    }
}
