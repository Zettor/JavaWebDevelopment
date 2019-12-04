package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.CurrencyDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.AccessoryCategoryService;
import by.ysenko.finaltask.service.CurrencyService;

import java.util.List;

public class CurrencyServiceImpl extends ServiceImpl implements CurrencyService {

    @Override
    public List<Currency> findAll() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        List<Currency> currencies = currencyDao.findAll();
        transaction.end();
        return currencies;
    }

    @Override
    public void delete(int id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        currencyDao.delete(id);
        transaction.end();

    }

    @Override
    public void add(Currency currency) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(currencyDao);
        currencyDao.create(currency);
        transaction.end();

    }
}
