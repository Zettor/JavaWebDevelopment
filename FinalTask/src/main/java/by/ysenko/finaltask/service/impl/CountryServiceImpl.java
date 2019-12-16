package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.dao.CountryDao;
import by.ysenko.finaltask.dao.CurrencyDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CountryService;

import java.util.List;

public class CountryServiceImpl extends ServiceImpl implements CountryService {

    @Override
    public List<Country> findAll()  {
        Transaction transaction = transactionFactory.createTransaction();
        CountryDao countryDao = daoFactory.createCountryDao();
        transaction.begin(countryDao);
        List<Country> countries=null;
        try {
            countries = countryDao.findAll();
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
        return countries;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        CountryDao countryDao = daoFactory.createCountryDao();
        transaction.begin(countryDao);
        try {
            countryDao.delete(id);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }

    @Override
    public void add(Country country)  {
        Transaction transaction = transactionFactory.createTransaction();
        CountryDao countryDao = daoFactory.createCountryDao();
        transaction.begin(countryDao);
        try{
        countryDao.create(country);
        transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }
}
