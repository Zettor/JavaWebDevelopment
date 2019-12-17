package by.ysenko.finaltask.dao;

public interface Transaction {

    void begin(Dao dao, Dao... daos) ;
    void end();


    void commit() ;

    void rollback() ;
}
