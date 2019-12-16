package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.Country;
import by.ysenko.finaltask.dao.CountryDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface CountryService {


    public List<Country> findAll(); ;

    public void delete(int id);

    public void add(Country country);
}
