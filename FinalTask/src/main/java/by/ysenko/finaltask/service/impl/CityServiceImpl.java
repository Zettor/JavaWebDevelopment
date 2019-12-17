package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.dao.CityDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.service.CityService;

import java.util.List;

public class CityServiceImpl extends ServiceImpl implements CityService {

    @Override
    public List<City> findByCountryId(Integer countryId)  {
        Transaction transaction = transactionFactory.createTransaction();
        CityDao cityDao = daoFactory.createCityDao();
        transaction.begin(cityDao);
        List<City> cities=null;
        try {
            cities = cityDao.findByCountryId(countryId);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
        return cities;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        CityDao cityDao = daoFactory.createCityDao();
        transaction.begin(cityDao);
        try {
            cityDao.delete(id);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
    }

    @Override
    public void add(City city)  {
        Transaction transaction = transactionFactory.createTransaction();
        CityDao cityDao = daoFactory.createCityDao();
        transaction.begin(cityDao);
        try{
        cityDao.create(city);
        transaction.commit();
    }catch (DaoException e){
        transaction.rollback();
    }
        transaction.end();
    }
}
