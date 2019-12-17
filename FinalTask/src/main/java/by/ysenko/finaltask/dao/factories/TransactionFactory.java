package by.ysenko.finaltask.dao.factories;

import by.ysenko.finaltask.dao.Transaction;

public interface TransactionFactory {
    Transaction createTransaction() ;

    public void init();

    public void close();


}
