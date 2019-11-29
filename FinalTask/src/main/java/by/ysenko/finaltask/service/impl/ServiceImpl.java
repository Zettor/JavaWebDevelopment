package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.factories.DaoFactory;
import by.ysenko.finaltask.dao.factories.TransactionFactory;
import by.ysenko.finaltask.dao.factories.impl.DaoFactoryImpl;
import by.ysenko.finaltask.dao.factories.impl.TransactionFactoryImpl;
import by.ysenko.finaltask.service.Service;

public abstract class ServiceImpl implements Service {
    protected TransactionFactory transactionFactory ;
    protected DaoFactory daoFactory ;
    protected ServiceImpl(){
        transactionFactory=new TransactionFactoryImpl();
        daoFactory=new DaoFactoryImpl();
    }
}
