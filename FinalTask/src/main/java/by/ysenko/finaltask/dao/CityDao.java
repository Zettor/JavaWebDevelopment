package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface CityDao extends Dao<City> {

    public List<City> findByCountryId(Integer countryId) throws DaoException;
}
