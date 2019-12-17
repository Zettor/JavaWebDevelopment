package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.dao.CurrencyDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.service.CurrencyService;

import java.util.List;

public class CurrencyServiceImpl extends ServiceImpl implements CurrencyService {

    @Override
    public List<Currency> findAll()  {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        List<Currency> currencies = null;
        try {
            currencies = currencyDao.findAll();
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return currencies;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        try {
            currencyDao.delete(id);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();

    }

    @Override
    public void add(Currency currency)  {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        try {
            currencyDao.create(currency);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }
}
