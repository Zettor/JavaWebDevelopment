package by.ysenko.finaltask.service;

import by.ysenko.finaltask.dao.factories.TransactionFactory;

public interface ConnectionService {

    public void init();

    public void close();
}
