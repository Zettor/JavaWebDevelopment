package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.City;
import by.ysenko.finaltask.dao.CityDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface CityService {

    public List<City> findByCountryId(Integer countryId);

    public void delete(int id);

    public void add(City city);
}
