package by.ysenko.finaltask.dao.factories;

import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;

public interface TransactionFactory {
    Transaction createTransaction() throws PersistentException;


}
