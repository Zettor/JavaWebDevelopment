package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.impl.*;

public interface Transaction {

    void begin(Dao dao, Dao... daos) ;
    void end();


    void commit() ;

    void rollback() ;
}
